package io.mycat.orientserver.handler.data_define;

import com.alibaba.druid.sql.ast.statement.SQLAlterViewRenameStatement;
import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 * ALTER
 [ALGORITHM = {UNDEFINED | MERGE | TEMPTABLE}]
 [DEFINER = { user | CURRENT_USER }]
 [SQL SECURITY { DEFINER | INVOKER }]
 VIEW view_name [(column_list)]
 AS select_statement
 [WITH [CASCADED | LOCAL] CHECK OPTION]
 */
public class AlterView {
    public static void handle(SQLAlterViewRenameStatement x, OConnection connection) {

        connection.writeok();

    }
}
