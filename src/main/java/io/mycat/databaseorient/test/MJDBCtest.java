package io.mycat.databaseorient.test;

import java.sql.*;

/**
 * Created by 长宏 on 2017/3/22 0022.
 */
public class MJDBCtest {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:9999/db1?user=root&password=123456");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("show tables");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
