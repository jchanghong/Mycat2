package io.mycat.databaseorient.adapter;

import com.orientechnologies.orient.core.db.OPartitionedDatabasePool;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import io.mycat.MycatServer;
import io.mycat.util.NameableExecutor;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 长宏 on 2017/3/20 0020.
 */
public class MDBadapter {
    public static NameableExecutor executor;
    public static Set<String> dbset = new HashSet<>();
    static {
        executor = MycatServer.getInstance().getBusinessExecutor();
        loaddbset();
    }

    public static ODatabaseDocumentTx getdbtx(String dbname) {
        if (!dbset.contains(dbname)) {
            return null;
        }
        ODatabaseDocumentTx documentTx = getdbpool(dbname).acquire();
        return documentTx;
    }
    public static ODatabaseDocumentTx getdbtx() {
        if (currentDB == null) {
            return null;
        }
        if (!dbset.contains(currentDB)) {
            return null;
        }
        ODatabaseDocumentTx documentTx = getdbpool(currentDB).acquire();
        return documentTx;
    }
    /**
     * The constant currentDB.
     */
    public static String currentDB;
    /**
     * The constant DB_DIR.
     */
    private static final String DB_DIR = "database";

    /**
     * The Hash map.
     */
    private static ConcurrentHashMap<String, OPartitionedDatabasePool> hashMap = new ConcurrentHashMap<>();

    /**
     * Deletedb boolean.
     *
     * @param dbname the dbname
     * @return the boolean
     */
    synchronized  public static void deletedb(String dbname) throws MException {
        if (dbset.contains(dbname)) {
            dbset.remove(dbname);
            hashMap.remove(dbname);
            executor.execute(()->{
                OPartitionedDatabasePool oDatabaseDocumentTx = getdbpool(dbname);
                ODatabaseDocumentTx documentTx = oDatabaseDocumentTx.acquire();
                documentTx.activateOnCurrentThread();
                documentTx.drop();
                documentTx.close();
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
      static   public void createdb(String dbname) throws MException{
        if (dbset.contains(dbname)) {
            throw new MException("db已经存在");
        }
        dbset.add(dbname);
        executor.execute(()->{
            createdb1(dbname);
        });
    }
    synchronized  private static void createdb1(String dbname) {
        new ODatabaseDocumentTx(getlccalurl(dbname)).create().close();
    }

    /**
     * Gets .
     *
     * @return the
     */
    private static Set<String> loaddbset() {
        dbset.clear();
        File file = new File(DB_DIR);
        if (!file.exists()) {
            file.mkdir();
            return dbset;
        }
        if (file.isFile()) {
//            file.delete();
            file.mkdir();
            return dbset;
        }
        for (File file1 : file.listFiles()) {
            if (file1.isDirectory()) {
                dbset.add(file1.getName());
            }
        }
        return dbset;
    }

    public static OPartitionedDatabasePool getdbpool(String dbname) {

        if (hashMap.containsKey(dbname)) {
            return hashMap.get(dbname);
        }
        OPartitionedDatabasePool pool = new OPartitionedDatabasePool(getlccalurl(dbname), "admin", "admin");
        hashMap.put(dbname, pool);
        return pool;
    }

    /**
     * Gets .
     *
     * @param petshop the petshop
     * @return the
     */
    public static String getmemoryurl(String petshop) {
        return "memory:"+DB_DIR+"/" + petshop;
    }

    /**
     * Gets .
     *
     * @param petshop the petshop
     * @return the
     */
    public static String getlccalurl(String petshop)
    {
        return "plocal:"+DB_DIR+"/" + petshop;
    }

    /**
     * Gets .
     *
     * @param url the url
     * @return the
     */
    public static String getdbnamefromurl(String url) {
        int index = url.lastIndexOf("/");
        return url.substring(index + 1);
    }

    /**
     * Gets .
     *
     * @param dbname the dbname
     * @return the
     */
    public static String getfilepath(String dbname) {
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
    public static Object exesql(String sql) throws MException {
        ODatabaseDocumentTx documentTx = null;
        if (currentDB == null) {
            throw new MException("db is null");
        }
        try {
            documentTx= getdbpool(currentDB).acquire();
            documentTx.activateOnCurrentThread();
            Object object=documentTx.command(new OCommandSQL(sql)).execute();
            return object;
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
    public static List<ODocument> exequery(String sqlquery) throws MException {
        ODatabaseDocumentTx documentTx = null;
        if (currentDB == null) {
            throw new MException("db is null");
        }
        try {
            documentTx = getdbpool(currentDB).acquire();
            documentTx.activateOnCurrentThread();
            List<ODocument> result = documentTx.query(
                    new OSQLSynchQuery<ODocument>(
                            sqlquery));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MException(e.getMessage());
        } finally {
            if (documentTx != null&& !documentTx.isClosed()) {
                documentTx.close();
            }
        }
    }
}
