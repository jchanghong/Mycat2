package io.mycat.orientserver.handler.data_define;

import com.alibaba.druid.sql.ast.statement.SQLDropViewStatement;
import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 */
public class DropView {
    public static void handle(SQLDropViewStatement x, OConnection connection) {

        connection.writeok();

    }
}
