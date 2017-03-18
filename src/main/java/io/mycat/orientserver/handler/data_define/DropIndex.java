package io.mycat.orientserver.handler.data_define;

import com.alibaba.druid.sql.ast.statement.SQLDropIndexStatement;
import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 */
public class DropIndex {
    public static void handle(SQLDropIndexStatement x, OConnection connection) {

        connection.writeok();

    }
}
