package io.mycat.orientserver.handler.data_mannipulation;

import com.alibaba.druid.sql.ast.statement.SQLInsertStatement;
import io.mycat.config.ErrorCode;
import io.mycat.databaseorient.adapter.MDBadapter;
import io.mycat.databaseorient.adapter.MException;
import io.mycat.net.mysql.OkPacket;
import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 * INSERT INTO tbl_name (a,b,c) VALUES(1,2,3),(4,5,6),(7,8,9);
 The values list for each row must be enclosed within parentheses.
 The following statement is illegal because the number of
 values in the list does not match the number of column names:

 INSERT INTO tbl_name (a,b,c) VALUES(1,2,3,4,5,6,7,8,9);
 */
public class Minsert {
    public static void handle(SQLInsertStatement x, OConnection connection) {
        if (MDBadapter.currentDB == null) {
            connection.writeErrMessage(ErrorCode.ER_NO_DB_ERROR, "没有选择数据库");
        }
        try {
            Object o = MDBadapter.exesql(x.toString());
            if (o instanceof Number) {
                OkPacket okPacket = new OkPacket();
                okPacket.read(okPacket.OK);
                okPacket.affectedRows = (long) o;
                okPacket.write(connection);
                connection.writeok();
                return;
            }
            connection.writeok();
        } catch (MException e) {
            e.printStackTrace();
            connection.writeErrMessage(e.getMessage());
        }
    }
}
