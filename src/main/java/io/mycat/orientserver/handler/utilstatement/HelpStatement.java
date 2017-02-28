package io.mycat.orientserver.handler.utilstatement;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlHelpStatement;
import io.mycat.config.ErrorCode;
import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/2/25 0025.
 */
public class HelpStatement {
    public static void handle(MySqlHelpStatement x, OConnection c) {
        c.writeErrMessage(ErrorCode.ER_UNKNOWN_COM_ERROR, "Unsupported statement");
    }
}
