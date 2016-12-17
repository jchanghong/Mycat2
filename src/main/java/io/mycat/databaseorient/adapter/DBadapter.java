package io.mycat.databaseorient.adapter;

import com.orientechnologies.orient.core.db.OPartitionedDatabasePool;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import io.mycat.databaseorient.sqlhander.sqlutil.MSQLutil;

import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jiang on 2016/12/17 0017.
 */
public class DBadapter {
    public static boolean isorient = true;
    volatile public static String currentDB;
    private List<String> set = null;
    public static String DB_DIR = "database";
    private static DBadapter sinfle = new DBadapter();
    public static DBadapter getInstance() {
        return sinfle;
    }

    public boolean deletedb(String dbname) {
        if (getalldbnames().contains(dbname)) {
            OPartitionedDatabasePool oDatabaseDocumentTx = hashMap.get(dbname);
            ODatabaseDocumentTx documentTx = oDatabaseDocumentTx.acquire();
            documentTx.activateOnCurrentThread();
            documentTx.drop();
            hashMap.remove(dbname);
            set.remove(dbname);
            return true;
        }
        return false;
    }
    public boolean createdb(String dbname) {
        if (getalldbnames().contains(dbname)) {
            return false;
        }
        new ODatabaseDocumentTx(getlccalurl(dbname)).create().close();
        hashMap.put(dbname, getdbpool(dbname));
        set.add(dbname);
        TableAdaptor.getInstance().hashMapdb2table.put(dbname, new HashSet<>());
        return true;
    }
    public List<String> getalldbnames() {
        if (set != null) {
            return set;
        }
        set= new ArrayList<>();
        File file = new File(DB_DIR);
        if (!file.exists()) {
            return set;
        }
        if (file.isFile()) {
            file.delete();
            return set;
        }
        for (File file1 : file.listFiles()) {
            if (file1.isDirectory()) {
                set.add(file1.getName());
            }
        }
        return set;
    }
    public ConcurrentHashMap<String, OPartitionedDatabasePool> hashMap = new ConcurrentHashMap<>();

    public DBadapter() {
        getalldbnames().stream().forEach(a->hashMap.put(a,getdbpool(a)));
    }


    private OPartitionedDatabasePool getdbpool(String dbname) {

        OPartitionedDatabasePool pool = new OPartitionedDatabasePool(getlccalurl(dbname), "admin", "admin");
        return pool;
    }

    public String getmemoryurl(String petshop) {
        return "memory:"+DB_DIR+"/" + petshop;
    }

    public String getlccalurl(String petshop)
    {
        return "plocal:"+DB_DIR+"/" + petshop;
    }

    public String getdbnamefromurl(String url) {
        int index = url.lastIndexOf("/");
        return url.substring(index + 1);
    }

    public String getfilepath(String dbname) {
        StringBuilder builder = new StringBuilder();
        builder.append(DB_DIR).append("/").append(dbname);
        return builder.toString();
    }

    public String exesql(String sql) throws OrientException{
        ODatabaseDocumentTx documentTx = null;
        try {
             documentTx= hashMap.get(currentDB).acquire();
            documentTx.activateOnCurrentThread();
            Object object=documentTx.command(new OCommandSQL(sql)).execute();
            documentTx.close();
            return object.toString();
        } catch (Exception e) {
            throw new OrientException(e.getMessage());
        } finally {
            if (documentTx != null&& !documentTx.isClosed()) {
                documentTx.close();
            }
        }

    }
    public List<Map<String,String>> exequery(String sqlquery) throws OrientException{
        ODatabaseDocumentTx documentTx = null;
        try {
            List<Map<String, String>> list = new ArrayList<>();
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
            throw new OrientException(e.getMessage());
        } finally {
            if (documentTx != null&& !documentTx.isClosed()) {
                documentTx.close();
            }
        }
    }

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
