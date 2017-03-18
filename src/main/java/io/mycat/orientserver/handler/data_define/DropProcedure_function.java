package io.mycat.orientserver.handler.data_define;

import com.alibaba.druid.sql.ast.statement.SQLDropFunctionStatement;
import com.alibaba.druid.sql.ast.statement.SQLDropProcedureStatement;
import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 */
public class DropProcedure_function {
    public static void handle(SQLDropFunctionStatement x, OConnection connection) {

        connection.writeok();
    }

    public static void handle(OConnection connection, SQLDropProcedureStatement x) {

        connection.writeok();
    }
}
