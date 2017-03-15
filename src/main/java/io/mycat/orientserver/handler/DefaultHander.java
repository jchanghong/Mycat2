package io.mycat.orientserver.handler;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlStatement;
import io.mycat.orientserver.OConnection;
import io.mycat.orientserver.response.MorientResponse;

/**
 * Created by 长宏 on 2017/2/26 0026.
 * 默认的处理器
 */
public class DefaultHander {
    public static void handle(SQLStatement statement, OConnection connection) {
        MorientResponse.response(connection,statement);

    }
    public static void handlequery(SQLStatement statement, OConnection connection) {
        MorientResponse.responseselect(connection, statement);
    }
}
