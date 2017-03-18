package io.mycat.orientserver.handler.data_mannipulation;

import com.alibaba.druid.sql.ast.statement.SQLCallStatement;
import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 */
public class Mcall {
    public static void handle(SQLCallStatement x, OConnection connection) {

        connection.writeok();

    }
}
