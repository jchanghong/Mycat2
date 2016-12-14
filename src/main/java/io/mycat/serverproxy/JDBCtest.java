package io.mycat.serverproxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by jiang on 2016/12/14 0014.
 */
public class JDBCtest {
    public static void main(String[] args) throws SQLException {
        String sql = "show databases;";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/changhong", "root", "0000");

    }
}
