package io.mycat.databaseorient.adapter;

import com.alibaba.druid.sql.ast.statement.SQLColumnDefinition;
import com.alibaba.druid.sql.ast.statement.SQLTableElement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OSchema;
import com.orientechnologies.orient.core.metadata.schema.OType;
import io.mycat.databaseorient.sqlhander.sqlutil.MStringUtil;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jiang on 2016/12/17 0017.
 */
public class TableAdaptor {
    /**
     * The constant TABLEDOT.
     */
    public static final String TABLEDOT = ".sql";
    private static TableAdaptor insta = new TableAdaptor();
    /**
     * The Hash mapdb 2 table.
     */
    public HashMap<String, Set<String>> hashMapdb2table = new HashMap<>();
    /**
     * The Hashmaptable 2 fild.
     * 关键字，db.table
     */
    public HashMap<String, HashMap<String, String>> hashmaptable2fild = new HashMap<>();

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static TableAdaptor getInstance() {
        return insta;
    }
    private TableAdaptor() {

        List<String> dbs = DBadapter.getInstance().getalldbnames();
        dbs.stream().forEach(a -> hashMapdb2table.put(a, getalltable(a)));
    }

    /**
     * Droptable boolean.
     *
     * @param dbname the dbname
     * @param table  the table
     * @return the boolean
     */
     public void droptable(String dbname,String table) throws MException{
      String getfilepath = getfilepath(dbname, table);
      File file = new File(getfilepath);
      if (!file.exists()) {
          throw new MException("table 不存在");
      }
      DBadapter.executor.execute(()-> droptableinter(dbname, table, getfilepath));

    }

 synchronized    private void droptableinter(String dbname, String table, String getfilepath) {
        ODatabaseDocumentTx db = DBadapter.getInstance().hashMap.get(dbname).acquire();
        db.activateOnCurrentThread();
        OSchema oSchema = db.getMetadata().getSchema();
        if (oSchema.existsClass(table)) {
            oSchema.dropClass(table);
        }
        db.close();
        File file1 = new File(getfilepath);
        if (file1.exists()) {
            file1.delete();
        }
        hashMapdb2table.get(dbname).remove(table);
        hashmaptable2fild.remove(dbname+table);
    }

    /**
     * Createtable boolean.
     *
     * @param dbname               the dbname
     * @param createTableStatement the create table statement
     * @return the boolean
     */
    public void createtable(String dbname, MySqlCreateTableStatement createTableStatement) throws MException{
//        System.out.println(createTableStatement.toString());
        String table = createTableStatement.getTableSource().toString();
        if (!hashMapdb2table.containsKey(dbname)) {
            throw new MException("db不存在");
        }
        if (hashMapdb2table.get(dbname).contains(table)) {
            throw new MException("table已经存在");
        }

        DBadapter.executor.execute(()->{
            try {
                createtableinter(dbname, createTableStatement, table);
            } catch (MException e) {
                e.printStackTrace();
            }
        });
    }

   synchronized private void createtableinter(String dbname, MySqlCreateTableStatement createTableStatement, String table) throws MException {
        ODatabaseDocumentTx db = DBadapter.getInstance().hashMap.get(dbname).acquire();
        db.activateOnCurrentThread();
        if (db.getMetadata().getSchema().existsClass(table)) {
            throw new MException("table已经存在");
        }
        Map<String, String> h = new HashMap<>();
        for (SQLTableElement sqlTableElement : createTableStatement.getTableElementList()) {
            SQLColumnDefinition columnDefinition = (SQLColumnDefinition) sqlTableElement;
            h.put(columnDefinition.getName().toString(), columnDefinition.getDataType().getName());
        }
        OClass account = db.getMetadata().getSchema()
                .createClass(table);
        h.entrySet().stream().forEach(a->addproperty(account,a));
        account.setStrictMode(true);//只能增加上面设置的属性，不能增加属性
        try {
            DataOutputStream stream = new DataOutputStream(new FileOutputStream(getfilepath(dbname, table)));
            stream.writeUTF(createTableStatement.toString());
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

        }
        hashMapdb2table.get(dbname).add(table);
        hashmaptable2fild.put(dbname+table, (HashMap<String, String>) h);
        db.close();
    }


    private void addproperty(OClass account, Map.Entry<String, String> a) {
        if (a.getValue().contains("int")) {
            account.createProperty(a.getKey(), OType.INTEGER);
        }
        else {
            account.createProperty(a.getKey(), OType.STRING);
        }
    }

    private Set<String> getalltable(String dbname) {

        Set<String> strings = new HashSet<>();
        File file = new File(DBadapter.getInstance().getfilepath(dbname));
        if (!file.exists() || !file.isDirectory()) {
            file.delete();
            return strings;
        }
        for (File file1 : file.listFiles()) {
            String d = file1.getName();
            if (d.endsWith(TABLEDOT)) {
//                inittablefilrs(file1);
                int in = d.lastIndexOf(".");
                strings.add(d.substring(0,in));
            }
        }
        return strings;
    }

    /**
     * Gets .
     *
     * @param dbname    the dbname
     * @param tablename the tablename
     * @return the
     */
    public HashMap<String,String> gettablefiled(String  dbname,String tablename) {
        HashMap hashMap = hashmaptable2fild.get(dbname + tablename);
        if (hashMap != null) {
            return hashMap;
        }
        hashMap = new HashMap();
        File file1 = new File(DBadapter.getInstance().getfilepath(dbname), tablename + TABLEDOT);
        StringBuilder builder = new StringBuilder();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(file1));
            while (scanner.hasNext()) {
                builder.append(scanner.nextLine());
                builder.append("  ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String sql = builder.toString();
        int i = sql.indexOf("CREATE");
        sql = sql.substring(i, sql.length());
        MySqlCreateTableStatement createTableStatement = null;
        MySqlStatementParser parser = new MySqlStatementParser(sql);
        createTableStatement = (MySqlCreateTableStatement) parser.parseCreateTable();
        String table = createTableStatement.getTableSource().toString();
        for (SQLTableElement sqlTableElement : createTableStatement.getTableElementList()) {
            SQLColumnDefinition columnDefinition = (SQLColumnDefinition) sqlTableElement;
            String key = columnDefinition.getName().toString();
            hashMap.put(MStringUtil.getfiledname(key), columnDefinition.getDataType().getName());
        }
        hashmaptable2fild.put(dbname+table, hashMap);
        return hashMap;
    }

    /**
     * Gets .
     *
     * @param dbname    the dbname
     * @param tablename the tablename
     * @return the
     */
    public String getfilepath(String dbname, String tablename) {
        StringBuilder builder = new StringBuilder();
        builder.append(DBadapter.getInstance().getfilepath(dbname)).append("/").append(tablename).append(TABLEDOT);
        return builder.toString();
    }

}
