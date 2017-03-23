package io.mycat.orientserver.handler.data_mannipulation;

import com.alibaba.druid.sql.ast.statement.SQLDeleteStatement;
import io.mycat.config.ErrorCode;
import io.mycat.databaseorient.adapter.MDBadapter;
import io.mycat.databaseorient.adapter.MException;
import io.mycat.net.mysql.OkPacket;
import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 * DELETE FROM somelog WHERE user = 'jcole'
 ORDER BY timestamp_column LIMIT 1;
 */
public class Mdelete {
    public static void handle(SQLDeleteStatement x, OConnection connection) {
        if (MDBadapter.currentDB == null) {
            connection.writeErrMessage(ErrorCode.ER_NO_DB_ERROR, "没有选择数据库");
            return;
        }
        try {
            Object o = MDBadapter.exesql(x.toString(),MDBadapter.currentDB);
            if (o instanceof Number) {
                OkPacket okPacket = new OkPacket();
                okPacket.read(okPacket.OK);
                okPacket.affectedRows = Long.parseLong(o.toString());
                okPacket.write(connection);
                return;
            }
            connection.writeok();
        } catch (MException e) {
            e.printStackTrace();
            connection.writeErrMessage(e.getMessage());
        }
    }
}
