package io.mycat.orientserver.handler.replication_statement;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import io.mycat.config.ErrorCode;
import io.mycat.orientserver.OConnection;

/**
 * Created by dell on 2017/3/27.
 *SET GLOBAL sql_slave_skip_counter = N
 *
 */
public class SET_GLOBAL_sql_slave_skip_counter {
    static String N=null;
    public static boolean isMe(String sql){
        String[] strings = sql.split("\\s+");
        String s=null;
        if (strings.length >2 && strings[0].equalsIgnoreCase("SET")&&strings[0].equalsIgnoreCase("global")) {
            for(int i=3;i<=(strings.length-1);i++)
                s=s+strings[i];
            N=s.substring(s.length()-1);
            s=s.substring(0,s.length()-2);
            if(s.equalsIgnoreCase("sql_slave_skip_counter="))
                return true;
        }
        return false;
    }
    public static void handle(String sql, OConnection c) {
        c.writeErrMessage(ErrorCode.ER_NOT_SUPPORTED_YET,"暂未支持");
    }
}
