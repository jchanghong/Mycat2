package io.mycat.databaseorient.sqlhander;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import io.mycat.databaseorient.sqlhander.sqlutil.MSQLutil;

public class SQLtest {
    public static void main(String[] args) {
        String sql = "create database db1";
        sql = "create table d(id int)";
        sql = "select * from t1";
        MySqlStatementParser parser = new MySqlStatementParser(sql);
        SQLStatement sqlStatement = parser.parseStatement();
        System.out.println(MSQLutil.gettablename((SQLSelectStatement) sqlStatement));
        SQLvisitor sqLvisitor = new SQLvisitor();
        sqlStatement.accept(sqLvisitor);

    }
}
