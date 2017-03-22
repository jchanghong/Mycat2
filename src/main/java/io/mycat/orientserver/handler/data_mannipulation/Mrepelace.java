package io.mycat.orientserver.handler.data_mannipulation;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlReplaceStatement;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import io.mycat.config.ErrorCode;
import io.mycat.databaseorient.adapter.MDBadapter;
import io.mycat.databaseorient.adapter.MException;
import io.mycat.databaseorient.adapter.MtableAdapter;
import io.mycat.net.mysql.OkPacket;
import io.mycat.orientserver.OConnection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 长宏 on 2017/3/18 0018.
 * mysql> REPLACE INTO test VALUES (1, 'Old', '2014-08-20 18:47:00');
 Query OK, 1 row affected (0.04 sec)

 mysql> REPLACE INTO test VALUES (1, 'New', '2014-08-20 18:47:42');
 Query OK, 2 rows affected (0.04 sec)
 */
public class Mrepelace {
    public static void handle(MySqlReplaceStatement x, OConnection connection) {

        if (MDBadapter.currentDB == null) {
            connection.writeErrMessage(ErrorCode.ER_NO_DB_ERROR, "没有选择数据库");
        }
        ODatabaseDocumentTx getdbtx = MDBadapter.getCurrentDB();
        try {
            String table = x.getTableName().toString();
//            getdbtx.activateOnCurrentThread();
            OClass oClass = MtableAdapter.gettableclass(table,getdbtx);
            Set<String> sets = new HashSet<>();
            oClass.properties().forEach(a -> sets.add(a.getName()));
            StringBuilder builder = new StringBuilder();
            builder.append(table + "(");
            sets.forEach(a->{
                builder.append(a + ",");
            });
            builder.deleteCharAt(builder.length() - 1);
            String sql = x.toString().replace(table, builder.toString());
            Object o = MDBadapter.exesql(sql);
//            getdbtx.close();
            if (o instanceof Number) {
                OkPacket okPacket = new OkPacket();
                okPacket.read(okPacket.OK);
                okPacket.affectedRows = (long) o;
                okPacket.write(connection);
                return;
            }
            connection.writeok();
        } catch (MException e) {
            e.printStackTrace();
            connection.writeErrMessage(e.getMessage());
        }
        finally {
            getdbtx.close();
        }
    }
}
