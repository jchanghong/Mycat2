package io.mycat.orientserver.handler.data_mannipulation;

import com.alibaba.druid.sql.ast.statement.SQLUpdateStatement;
import io.mycat.config.ErrorCode;
import io.mycat.databaseorient.adapter.MDBadapter;
import io.mycat.databaseorient.adapter.MException;
import io.mycat.net.mysql.OkPacket;
import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 * UPDATE t1 SET col1 = col1 + 1;
 */
public class Mupdate {
    public static void handle(SQLUpdateStatement x, OConnection connection) {
        if (MDBadapter.currentDB == null) {
            connection.writeErrMessage(ErrorCode.ER_NO_DB_ERROR, "没有选择数据库");
        }
        try {
            Object o = MDBadapter.exesql(x.toString());
            OkPacket okPacket = new OkPacket();
            okPacket.read(okPacket.OK);
            okPacket.affectedRows = (long) o;
            okPacket.write(connection);
        } catch (MException e) {
            e.printStackTrace();
            connection.writeErrMessage(e.getMessage());
        }
    }
}
