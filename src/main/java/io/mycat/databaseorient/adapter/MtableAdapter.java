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
            ODatabaseDocumentTx db = MDBadapter.getdbpool(dbname).acquire();
            db.activateOnCurrentThread();
            OSchema oSchema = db.getMetadata().getSchema();
            if (oSchema.existsClass(table)) {
                MDBadapter.executor.execute(() -> {
                    db.activateOnCurrentThread();
                    oSchema.dropClass(table);
                    db.close();
                });
            }
            else {
                db.close();
                throw new MException("table 不存在");
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
        ODatabaseDocumentTx db = MDBadapter.getdbpool(dbname).acquire();
        db.activateOnCurrentThread();
        OSchema oSchema = db.getMetadata().getSchema();
        String table = createTableStatement.getTableSource().toString();
        if (oSchema.existsClass(table)) {
            throw new MException("table已经存在");
        }
        MDBadapter.executor.execute(()->{
            db.activateOnCurrentThread();
            OClass oClass = db.getMetadata().getSchema()
                    .createClass(table);
            oClass.setStrictMode(true);
            Map<String, String> maps = MSQLutil.gettablenamefileds(createTableStatement);
            maps.entrySet().forEach(e->{
                oClass.createProperty(e.getKey(), e.getValue().equalsIgnoreCase("int") ? OType.INTEGER : OType.STRING);
            });
            db.close();
        });
    }

   static public Set<String> getalltable(String dbname) {
       Set<String> strings = new HashSet<>();
       ODatabaseDocumentTx db = MDBadapter.getdbpool(dbname).acquire();
       db.activateOnCurrentThread();
       OSchema oSchema = db.getMetadata().getSchema();
       oSchema.getClasses().forEach(a->strings.add(a.getName()));
        return strings;
    }
    public static OClass gettableclass(String tablename) {
        ODatabaseDocumentTx db = MDBadapter.getdbpool(MDBadapter.currentDB).acquire();
        db.activateOnCurrentThread();
        OSchema oSchema = db.getMetadata().getSchema();
        return oSchema.getClass(tablename);
    }

}
