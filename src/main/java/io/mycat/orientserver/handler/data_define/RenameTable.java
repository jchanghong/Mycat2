package io.mycat.orientserver.handler.data_define;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlRenameTableStatement;
import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 */
public class RenameTable {
    public static void handle(MySqlRenameTableStatement x, OConnection connection) {
       connection.writeok();
    }
}
