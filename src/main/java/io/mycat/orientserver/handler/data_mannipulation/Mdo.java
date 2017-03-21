package io.mycat.orientserver.handler.data_mannipulation;

import io.mycat.net.mysql.OkPacket;
import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 * mysql> SELECT SLEEP(5);
 +----------+
 | SLEEP(5) |
 +----------+
 |        0 |
 +----------+
 1 row in set (5.02 sec)
 DO, on the other hand, pauses without producing a result set.:

 mysql> DO SLEEP(5);
 Query OK, 0 rows affected (4.99 sec)
 */
public class Mdo {
    public static boolean isme(String sql) {
        String sqll = sql.toUpperCase().trim();
        String list[] = sqll.split("\\s+");
        if (list.length > 1 && list[0].equals("DO")) {
            return true;
        }
        return false;
    }
    public static void handle(String sql, OConnection c) {
        c.writeok();
    }
}
