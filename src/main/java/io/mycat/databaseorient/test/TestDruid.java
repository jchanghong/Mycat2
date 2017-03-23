package io.mycat.databaseorient.test;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;

/**
 * Created by 长宏 on 2017/3/23 0023.
 */
public class TestDruid {
    public static void main(String[] args) {
        String sql="SELECT  @@session.auto_increment_increment AS auto_increment_increment" ;
        String sql1 = "select @@se.ii";
        MySqlStatementParser parser = new MySqlStatementParser(sql);
        SQLStatement sqlStatement = parser.parseStatement();
        MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
        sqlStatement.accept(visitor);

        System.out.println(visitor.getColumns());
    }
}
