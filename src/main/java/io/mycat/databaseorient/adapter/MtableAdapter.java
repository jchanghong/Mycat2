package io.mycat.databaseorient.adapter;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OSchema;
import com.orientechnologies.orient.core.metadata.schema.OType;
import io.mycat.databaseorient.sqlhander.sqlutil.MSQLutil;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by 长宏 on 2017/3/20 0020.
 */
public class MtableAdapter {
    /**
     * Droptable boolean.
     *
     * @param dbname the dbname
     * @param table  the table
     * @return the boolean
     */
    public static void droptable(String dbname,String table) throws MException {
        if (!MDBadapter.dbset.contains(dbname)) {
            throw new MException("db不存在");
        }
      final   ODatabaseDocumentTx db  = MDBadapter.getCurrentDB(dbname);;
        try {
            OSchema oSchema = db.getMetadata().getSchema();
            if (oSchema.existsClass(table)) {
                MDBadapter.executor.execute(() -> {
                    ODatabaseDocumentTx db2 = MDBadapter.getCurrentDB(dbname);
                    try {
                        db2.activateOnCurrentThread();
                        db2.getMetadata().getSchema().dropClass(table);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        db2.close();
                    }
                });
            }
            else {
                throw new MException("table 不存在");
            }
        } catch (Exception e) {
            throw new MException(e.getMessage());
        }
        finally {
            db.close();
        }
    }
    /**
     * Createtable boolean.
     *
     * @param dbname               the dbname
     * @param createTableStatement the create table statement
     * @return the boolean
     */
    public static void createtable(String dbname, MySqlCreateTableStatement createTableStatement) throws MException{
        if (!MDBadapter.dbset.contains(dbname)) {
            throw new MException("db不存在");
        }
        ODatabaseDocumentTx db = MDBadapter.getCurrentDB(dbname);
//        db.activateOnCurrentThread();
        OSchema oSchema = db.getMetadata().getSchema();
        String table = createTableStatement.getTableSource().toString();
        if (oSchema.existsClass(table)) {
            db.close();
            throw new MException("table已经存在");
        }
        db.close();
        MDBadapter.executor.execute(()->{
          ODatabaseDocumentTx documentTx=MDBadapter.getCurrentDB(dbname);
//            db.activateOnCurrentThread();
            try {
                OClass oClass = documentTx.getMetadata().getSchema()
                        .createClass(table);
                oClass.setStrictMode(true);
                Map<String, String> maps = MSQLutil.gettablenamefileds(createTableStatement);
                maps.entrySet().forEach(e->{
                    if (e.getValue().toLowerCase().contains("int")) {
                        oClass.createProperty(e.getKey(), OType.INTEGER );
                    }
                    else   if (e.getValue().toLowerCase().contains("varchar")) {
                        oClass.createProperty(e.getKey(), OType.STRING );
                    }
                    else   if (e.getValue().toLowerCase().contains("datatime")) {
                        oClass.createProperty(e.getKey(), OType.DATETIME );
                    }
                    else  if (e.getValue().toLowerCase().contains("times")) {
                        oClass.createProperty(e.getKey(), OType.DATETIME );
                    }
                    else   { oClass.createProperty(e.getKey(), OType.STRING );}
                });
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                documentTx.close();
            }
        });
    }

    /**
     * Gets .
     *
     * @param dbname the dbname
     * @param db     the db不关闭
     * @return the
     */
    static public Set<String> getalltable(ODatabaseDocumentTx db) {
       Set<String> strings = new HashSet<>();
       db.activateOnCurrentThread();
       OSchema oSchema = db.getMetadata().getSchema();
       oSchema.getClasses().forEach(a->strings.add(a.getName()));
        return strings;
    }

    /**
     * Gets .
     *
     * @param tablename the tablename
     * @param db        the db不关闭
     * @return the
     */
    public static OClass gettableclass(String tablename,ODatabaseDocumentTx db) {
        db.activateOnCurrentThread();
        OSchema oSchema = db.getMetadata().getSchema();
        return oSchema.getClass(tablename);
    }

    /**
     * Gets .
     *
     * @param dbname    the dbname
     * @param tablename the tablename
     * @param db        the db不关闭
     * @return the
     */
    public static OClass gettableclass(String dbname,String tablename,ODatabaseDocumentTx db) {
        db.activateOnCurrentThread();
        OSchema oSchema = db.getMetadata().getSchema();
        return oSchema.getClass(tablename);
    }

}
