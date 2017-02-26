package io.mycat.orientserver.handler.adminstatement;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlShowDatabasesStatement;
import io.mycat.orientserver.OConnection;
import io.mycat.orientserver.response.ShowDatabases;

/**
 * Created by 长宏 on 2017/2/26 0026.
 */
public class ShowDatabase {
    public static void handle(MySqlShowDatabasesStatement showDatabasesStatement, OConnection c) {
        ShowDatabases.response(c);
    }
}
