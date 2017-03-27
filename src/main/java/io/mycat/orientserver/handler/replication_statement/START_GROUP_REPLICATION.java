package io.mycat.orientserver.handler.replication_statement;

import io.mycat.config.ErrorCode;
import io.mycat.orientserver.OConnection;

/**
 * Created by dell on 2017/3/27.
 */
public class START_GROUP_REPLICATION {
    public static boolean isMe(String sql){
        String[] strings = sql.split("\\s+");
        if (strings.length ==2 && strings[0].equalsIgnoreCase("START")&&strings[1].equalsIgnoreCase("GROUP_REPLICATION")) {
            return true;
        }
        return false;
    }
    public static void handle(String sql, OConnection c) {
        c.writeErrMessage(ErrorCode.ER_NOT_SUPPORTED_YET,"暂未支持");
    }
}
