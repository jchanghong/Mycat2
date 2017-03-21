package io.mycat.orientserver.handler;

import com.alibaba.druid.sql.ast.SQLStatement;
import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/2/26 0026.
 * 默认的处理器
 */
public class DefaultHander {
    public static void handle(SQLStatement statement, OConnection connection) {
        connection.writeNotSurrport();
//        MorientSelectResponse.response(connection,statement);

    }
    public static void handlequery(SQLStatement statement, OConnection connection) {
        connection.writeNotSurrport();
//        MorientSelectResponse.responseselect(connection, statement);
    }
}
