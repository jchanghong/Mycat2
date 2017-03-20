package io.mycat.orientserver.handler.data_define;

import io.mycat.orientserver.OConnection;

/**
 * Created by 长宏 on 2017/3/18 0018.
 */
public class DropEVENT {
    public static boolean isdropevent(String sql) {
        return true;
    }

    public static void handle(String sql, OConnection c) {

    }
}
