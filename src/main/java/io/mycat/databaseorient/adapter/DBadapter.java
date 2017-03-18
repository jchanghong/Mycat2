package io.mycat.databaseorient.adapter;

import com.orientechnologies.orient.core.db.OPartitionedDatabasePool;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import io.mycat.MycatServer;
import io.mycat.databaseorient.sqlhander.sqlutil.MSQLutil;
import io.mycat.util.NameableExecutor;

import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jiang on 2016/12/17 0017.
 * orientdb和关系数据库的映射.可以直接执行orient的sql语法，但是mysql的语法需要转化以后才能传过来执行。
 * 我们需要做的也就是做这个转化过程。
 */
public class DBadapter {
    public static NameableExecutor executor;
    /**
     * The constant isorient.
     */
    public static boolean isorient = true;
    /**
     * The constant currentDB.
     */
     public static String currentDB;
    /**
     * The constant DB_DIR.
     */
    private static final String DB_DIR = "database";
    private List<String> dbset = null;
    /**
     * The Hash map.
     */
    public ConcurrentHashMap<String, OPartitionedDatabasePool> hashMap = new ConcurrentHashMap<>();
    private static DBadapter sinfle = new DBadapter();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static DBadapter getInstance() {
        return sinfle;
    }

    /**
     * Deletedb boolean.
     *
     * @param dbname the dbname
     * @return the boolean
     */
   synchronized public void deletedb(String dbname) throws MException {
        if (getalldbnames().contains(dbname)) {
            executor.execute(()->{
                OPartitionedDatabasePool oDatabaseDocumentTx = hashMap.get(dbname);
                ODatabaseDocumentTx documentTx = oDatabaseDocumentTx.acquire();
                documentTx.activateOnCurrentThread();
                documentTx.drop();
                hashMap.remove(dbname);
                dbset.remove(dbname);
            });
        }else {
            throw new MException("db 不存在");
        }

    }

    /**
     * Createdb boolean.
     *
     * @param dbname the dbname
     * @return the boolean
     */
  synchronized   public void createdb(String dbname) throws MException{
        if (getalldbnames().contains(dbname)) {
            throw new MException("db已经存在");
        }
        executor.execute(()->{
            new ODatabaseDocumentTx(getlccalurl(dbname)).create().close();
            hashMap.put(dbname, getdbpool(dbname));
            dbset.add(dbname);
            TableAdaptor.getInstance().hashMapdb2table.put(dbname, new HashSet<>());
        });
    }

    /**
     * Gets .
     *
     * @return the
     */
    public List<String> getalldbnames() {
        if (dbset != null) {
            return dbset;
        }
        dbset =new ArrayList<>();
        File file = new File(DB_DIR);
        if (!file.exists()) {
            return dbset;
        }
        if (file.isFile()) {
            file.delete();
            return dbset;
        }
        for (File file1 : file.listFiles()) {
            if (file1.isDirectory()) {
                dbset.add(file1.getName());
            }
        }
        return dbset;
    }

    /**
     * Instantiates a new D badapter.
     */
    public DBadapter() {
        executor = MycatServer.getInstance().getBusinessExecutor();
        getalldbnames().stream().forEach(a->hashMap.put(a,getdbpool(a)));
    }


    private OPartitionedDatabasePool getdbpool(String dbname) {

        OPartitionedDatabasePool pool = new OPartitionedDatabasePool(getlccalurl(dbname), "admin", "admin");
        return pool;
    }

    /**
     * Gets .
     *
     * @param petshop the petshop
     * @return the
     */
    public String getmemoryurl(String petshop) {
        return "memory:"+DB_DIR+"/" + petshop;
    }

    /**
     * Gets .
     *
     * @param petshop the petshop
     * @return the
     */
    public String getlccalurl(String petshop)
    {
        return "plocal:"+DB_DIR+"/" + petshop;
    }

    /**
     * Gets .
     *
     * @param url the url
     * @return the
     */
    public String getdbnamefromurl(String url) {
        int index = url.lastIndexOf("/");
        return url.substring(index + 1);
    }

    /**
     * Gets .
     *
     * @param dbname the dbname
     * @return the
     */
    public String getfilepath(String dbname) {
        StringBuilder builder = new StringBuilder();
        builder.append(DB_DIR).append("/").append(dbname);
        return builder.toString();
    }

    /**
     * Exesql string.
     *
     * @param sql the sql 不是select语句或者show语句 ,show dddd
     * @return the string
     * @throws MException the orient exception
     */
    public String exesql(String sql) throws MException {
        ODatabaseDocumentTx documentTx = null;
        if (currentDB == null) {
            return "error";
        }
        try {
             documentTx= hashMap.get(currentDB).acquire();
            documentTx.activateOnCurrentThread();
            Object object=documentTx.command(new OCommandSQL(sql)).execute();
            documentTx.close();
            return object.toString();
        } catch (Exception e) {
            throw new MException(e.getMessage());
        } finally {
            if (documentTx != null&& !documentTx.isClosed()) {
                documentTx.close();
            }
        }

    }

    /**
     * Exequery list.
     *
     * @param sqlquery the sqlquery
     * @return the list
     * @throws MException the orient exception
     */
    public List<Map<String,String>> exequery(String sqlquery) throws MException {
        ODatabaseDocumentTx documentTx = null;

        try {
            List<Map<String, String>> list = new ArrayList<>();
            if (currentDB == null) {

                return list;
            }
            String tablename = MSQLutil.gettablename(sqlquery);
            Map<String, String> alls = TableAdaptor.getInstance().gettablefiled(currentDB, tablename);
            List<String> select = MSQLutil.gettablenamefileds(sqlquery);
             documentTx = hashMap.get(currentDB).acquire();
            documentTx.activateOnCurrentThread();
            List<ODocument> result = documentTx.query(
                    new OSQLSynchQuery<ODocument>(
                            sqlquery));
            documentTx.close();
            setemptylist(list, result, alls, select);
            return list;
        } catch (Exception e) {
            throw new MException(e.getMessage());
        } finally {
            if (documentTx != null&& !documentTx.isClosed()) {
                documentTx.close();
            }
        }
    }
    //alls是名字和类型
    private void setemptylist(List<Map<String, String>> list, List<ODocument> result, Map<String, String> alls, List<String> select) {
        if (result == null || result.size() == 0) {
            return;
        }
        if (select.contains("*")) {
            for (ODocument oDocument : result) {
                HashMap<String, String> e = new HashMap<>();
                for (String s : alls.keySet()) {
                        e.put(s, oDocument.field(s));
                }
                list.add(e);
            }
            return;
        }
        for (ODocument oDocument : result) {
            for (String s : select) {
                if (alls.keySet().contains(s)) {
                    HashMap<String, String> e = new HashMap<>();
                    e.put(s, oDocument.field(s));
                    list.add(e);
                }
            }
        }
    }

}
