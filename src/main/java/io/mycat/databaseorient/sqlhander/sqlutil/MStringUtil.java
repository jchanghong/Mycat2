package io.mycat.databaseorient.sqlhander.sqlutil;

/**
 * Created by jiang on 2016/12/17 0017.
 */
public class MStringUtil {
    public static String getfiledname(String filed) {
        if (filed.startsWith("'") || filed.startsWith("`")) {
            return filed.substring(1, filed.length() - 1);
        }
        else {
            return filed;
        }
    }
}
