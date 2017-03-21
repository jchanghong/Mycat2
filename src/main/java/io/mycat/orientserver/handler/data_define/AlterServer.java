package io.mycat.orientserver.handler.data_define;

import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 * ALTER SERVER  server_name
 OPTIONS (option [, option] ...)
 Alters the server information for server_name,
 adjusting any of the options permitted in the CREATE SERVER statement.
 The corresponding fields in the mysql.servers table are updated accordingly.
 This statement requires the SUPER privilege.

 For example, to update the USER option:

 ALTER SERVER s OPTIONS (USER 'sally');
 ALTER SERVER does not cause an automatic commit.
 */
public class AlterServer {
    public static boolean isme(String sql) {
        String sqll = sql.toUpperCase().trim();
        String list[] = sqll.split("\\s+");
        if (list.length > 2 && list[0].equals("ALTER") && list[1].equals("SERVER")) {
            return true;
        }
        return false;
    }
    public static void handle(String sql, OConnection c) {
        c.writeok();
    }
}
