package io.mycat.orientserver.handler.data_define;

import com.alibaba.druid.sql.ast.statement.SQLAlterDatabaseStatement;
import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 */
public class AlterDatabase {
    public static void handle(SQLAlterDatabaseStatement x, OConnection connection) {

        connection.writeok();
    }
}
