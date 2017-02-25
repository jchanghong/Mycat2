package io.mycat.databaseorient.sqlhander.sqlutil;

import com.alibaba.druid.sql.ast.statement.SQLCreateDatabaseStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiang on 2016/12/17 0017.
 */
public class MSQLutil {
    public static String gettablename(SQLSelectStatement sqlStatement) {
        MySqlSelectQueryBlock select = (MySqlSelectQueryBlock) sqlStatement.getSelect().getQuery();
        return select.getFrom().toString();
    }
    public static List<String> gettablenamefileds(SQLSelectStatement sqlStatement) {
        MySqlSelectQueryBlock select = (MySqlSelectQueryBlock) sqlStatement.getSelect().getQuery();
        List<String> list = new ArrayList<>();
        select.getSelectList().stream().forEach(a->list.add(a.getExpr().toString()));
        return list;
    }
 public static String gettablename(String sqlStatement) {
     SQLSelectStatement sqlSelectStatement = null;
     MySqlStatementParser parser = new MySqlStatementParser(sqlStatement);
     sqlSelectStatement = (SQLSelectStatement) parser.parseSelect();
     return gettablename(sqlSelectStatement);
    }
    public static List<String> gettablenamefileds(String sqlStatement) {
        SQLSelectStatement sqlSelectStatement = null;
        MySqlStatementParser parser = new MySqlStatementParser(sqlStatement);
        sqlSelectStatement = (SQLSelectStatement) parser.parseSelect();
        return gettablenamefileds(sqlSelectStatement);
    }

    public static String getdbname(SQLCreateDatabaseStatement statement) {
        return statement.getName().getSimpleName();
    }
    public static void main(String[] args) {

        System.out.println(gettablenamefileds("select *,rff from dd"));
        System.out.println(gettablename("select * from dd"));
    }
}
