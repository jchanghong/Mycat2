package io.mycat.orientserver.handler.data_define;

import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 * ALTER INSTANCE ROTATE INNODB MASTER KEY
 ALTER INSTANCE, introduced in MySQL 5.7.11, defines actions applicable to a MySQL server instance. Using ALTER INSTANCE requires the SUPER privilege.

 The ALTER INSTANCE ROTATE INNODB MASTER KEY statement is used
 to rotate the master encryption key used for InnoDB tablespace encryption.
 A keyring plugin must be loaded to use this statement.
 For information about keyring plugins,
 see Section 7.5.4, “The MySQL Keyring”.
 */
public class AlterInstall {
    public static boolean isme(String sql) {
        String sqll = sql.toUpperCase().trim();
        String list[] = sqll.split("\\s+");
        if (list.length > 2 && list[0].equals("ALTER") && list[1].equals("INSTANCE")) {
            return true;
        }
        return false;
    }
    public static void handle(String sql, OConnection c) {
        c.writeok();
    }
}
