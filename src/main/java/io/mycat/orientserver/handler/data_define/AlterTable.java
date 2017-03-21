package io.mycat.orientserver.handler.data_define;

import com.alibaba.druid.sql.ast.statement.SQLAlterTableStatement;
import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 * ALTER TABLE t2 DROP COLUMN c, DROP COLUMN d;
 */
public class AlterTable {
    public static void handle(SQLAlterTableStatement x, OConnection connection) {

        connection.writeok();

    }
}
