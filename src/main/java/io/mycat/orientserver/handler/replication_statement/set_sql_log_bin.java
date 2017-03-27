package io.mycat.orientserver.handler.replication_statement;

import io.mycat.config.ErrorCode;
import io.mycat.orientserver.OConnection;

/**
 * Created by zhang on 2017/3/27.
 * SET sql_log_bin = {0|1}
 *
 */
public class set_sql_log_bin {
    public static boolean isMe(String sql){
        String[] strings = sql.split("\\s+");
        String s=null;
        if (strings.length >=2 && strings[0].equalsIgnoreCase("set")) {
            for(int i=1;i<=(strings.length-1);i++)
                s=s+strings[i];
            if(s.equalsIgnoreCase("sql_log_bin=0")||s.equalsIgnoreCase("sql_log_bin=1"))
                return true;
        }
        return false;
    }
    public static void handle(String sql, OConnection c) {
        c.writeErrMessage(ErrorCode.ER_NOT_SUPPORTED_YET,"暂未支持");
    }
}
