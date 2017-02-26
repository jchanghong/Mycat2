package io.mycat.orientserver.handler.data_define;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import io.mycat.config.ErrorCode;
import io.mycat.databaseorient.adapter.DBadapter;
import io.mycat.databaseorient.adapter.TableAdaptor;
import io.mycat.orientserver.OConnection;

/**
 * Created by jiang on 2017/2/26 0026.
 */
public class CreateTable {
    public static void handle(MySqlCreateTableStatement x, OConnection c) {
        if (DBadapter.currentDB == null) {
            c.writeErrMessage(ErrorCode.ER_NO_DB_ERROR, "no database selected!!");
            return;
        }
        boolean b = TableAdaptor.getInstance().createtable(DBadapter.currentDB, x);
        if (b) {
            c.writeok();
        }
        else {
            c.writeErrMessage(ErrorCode.ER_BAD_TABLE_ERROR,"错误");
        }
    }
}
