package io.mycat.orientserver.handler.replication_statement;

import io.mycat.config.ErrorCode;
import io.mycat.orientserver.OConnection;

/**
 * Created by dell on 2017/3/27.
 *eg:
 *  CHANGE REPLICATION FILTER
 *     REPLICATE_DO_DB = (d1), REPLICATE_IGNORE_DB = (d2);
 */
public class CHANGE_REPLICATION_FILTER {
    static String  options=null;
    public static boolean isMe(String sql){
        String[] strings = sql.split("\\s+");
        if (strings.length > 3 && strings[0].equalsIgnoreCase("change") && strings[1].equalsIgnoreCase("replication") && strings[2].equalsIgnoreCase("filter")) {
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
