package io.mycat.orientserver.handler.utilstatement;

import com.alibaba.druid.sql.ast.statement.SQLUseStatement;
import io.mycat.config.ErrorCode;
import io.mycat.databaseorient.adapter.MDBadapter;
import io.mycat.net.mysql.OkPacket;
import io.mycat.orientserver.OConnection;
import io.mycat.util.StringUtil;

import java.nio.ByteBuffer;

/**
 * Created by jiang on 2017/2/26 0026.
 */
public class Usedatabase {
    public static void handle(SQLUseStatement x, OConnection connection) {
        String schema = x.getDatabase().toString();
        int length = schema.length();
        if (length > 0) {
            if (schema.endsWith(";")) {
                schema = schema.substring(0, schema.length() - 1);
            }
            schema = StringUtil.replaceChars(schema, "`", null);
            length = schema.length();
            if (schema.charAt(0) == '\'' && schema.charAt(length - 1) == '\'') {
                schema = schema.substring(1, length - 1);
            }
        }
        // 检查schema的有效性
        if (!MDBadapter.dbset.contains(schema)) {
            connection.writeErrMessage(ErrorCode.ER_BAD_DB_ERROR, "Unknown database '" + schema + "'");
            return;
        }
        MDBadapter.currentDB = schema;
        ByteBuffer buffer = connection.allocate();
        connection.write(connection.writeToBuffer(OkPacket.OK, buffer));
    }
}
