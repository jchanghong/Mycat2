package io.mycat.orientserver.handler.utilstatement;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlHelpStatement;
import io.mycat.backend.mysql.PacketUtil;
import io.mycat.config.ErrorCode;
import io.mycat.databaseorient.adapter.DBadapter;
import io.mycat.net.AbstractConnection;
import io.mycat.net.mysql.*;
import io.mycat.orientserver.OConnection;
import io.mycat.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;

import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.header;
import static io.mycat.net.mysql.EOFPacket.FIELD_COUNT;

/**
 * Created by 长宏 on 2017/2/25 0025.
 */
public class HelpStatement {

    public static void handle(MySqlHelpStatement x, OConnection c) {


        String helpstatment = x.toString();
        if (helpstatment.contains("use")) {
            //c.writeErrMessage(ErrorCode.ER_UNKNOWN_COM_ERROR, "The USE db_name statement tells MySQL to use the db_name database as the default (current) database for subsequent statements. ");
       //   c.writeErrMessage(ErrorCode.ER_UNKNOWN_COM_ERROR, "Unsuppoted Message ");

//        c.writeOkMessage("hello");


            return;
        }
        if (helpstatment.contains("show")) {
            return;
        }
        if (helpstatment.contains("select")) {
            return;
        }
        if (helpstatment.contains("create")) {
            return;
        }
        if (helpstatment.contains("insert")) {
            return;
        }
        if (helpstatment.contains("alter")) {
            return;
        }
    }
}
