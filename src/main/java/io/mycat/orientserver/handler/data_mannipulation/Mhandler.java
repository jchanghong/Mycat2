package io.mycat.orientserver.handler.data_mannipulation;

import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 * HANDLER tbl_name READ `PRIMARY` ...
 */
public class Mhandler {
    public static boolean isme(String sql) {
        String sqll = sql.toUpperCase().trim();
        String list[] = sqll.split("\\s+");
        if (list.length > 0 && list[0].equals("HANDLER")) {
            return true;
        }
        return false;
    }
    public static void handle(String sql, OConnection c) {
        c.writeok();
    }
}
