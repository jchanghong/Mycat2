package io.mycat.orientserver.handler.data_define;

import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 * ALTER TABLESPACE tablespace_name
 {ADD|DROP} DATAFILE 'file_name'
 [INITIAL_SIZE [=] size]
 [WAIT]
 ENGINE [=] engine_name
 This statement can be used either to add a new data file, or to drop a data file from a tablespace.
 */
public class AlterTableSpace {
    public static boolean isme(String sql) {
        String sqll = sql.toUpperCase().trim();
        String list[] = sqll.split("\\s+");
        if (list.length > 2 && list[0].equals("ALTER") && list[1].equals("TABLESPACE")) {
            return true;
        }
        return false;
    }
    public static void handle(String sql, OConnection c) {
        c.writeok();
    }
}
