package io.mycat.orientserver.handler.data_define;

import com.alibaba.druid.sql.ast.statement.SQLCreateTableStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import io.mycat.config.ErrorCode;
import io.mycat.databaseorient.adapter.DBadapter;
import io.mycat.databaseorient.adapter.MException;
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
        try {
            TableAdaptor.getInstance().createtable(DBadapter.currentDB, x);
            c.writeok();
            return;
        } catch (MException e) {
            e.printStackTrace();
            c.writeErrMessage(e.getMessage());
        }

    }

    public static void handle(OConnection connection, SQLCreateTableStatement x) {


    }
}
