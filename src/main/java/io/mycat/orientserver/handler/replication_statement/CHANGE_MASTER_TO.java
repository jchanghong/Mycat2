package io.mycat.orientserver.handler.replication_statement;

import io.mycat.config.ErrorCode;
import io.mycat.orientserver.OConnection;

/**
 * Created by dell on 2017/3/27.
 * CHANGE MASTER TO option [, option] ... [ channel_option ]
 * eg:
 * CHANGE MASTER TO MASTER_NAME=host1, MASTER_PORT=3002 FOR CHANNEL channel2
 * CHANGE MASTER TO MASTER_PASSWORD='new3cret';
 */
public class CHANGE_MASTER_TO {
    static String  options=null;
    public static boolean isMe(String sql){
        String[] strings = sql.split("\\s+");
        if (strings.length > 3 && strings[0].equalsIgnoreCase("change") && strings[1].equalsIgnoreCase("master") && strings[2].equalsIgnoreCase("to")) {
            for(int i=4;i<=(strings.length-1);i++)
                options=options+strings[i];
            return true;
        }
        return false;
    }
    public static void handle(String sql, OConnection c) {
        c.writeErrMessage(ErrorCode.ER_NOT_SUPPORTED_YET,"暂未支持");
    }
}
