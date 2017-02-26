package io.mycat.databaseorient.adapter;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jiang on 2016/12/17 0017.
 */
public class TableAdaptorTest {
    /**
     * Gets .
     *
     * @throws Exception the exception
     */
    @Test
    public void gettablefiled() throws Exception {

        HashMap hashMap = TableAdaptor.getInstance().gettablefiled("petshop1", "aaata");
        System.out.println(hashMap.toString());
        System.out.println(TableAdaptor.getInstance().hashmaptable2fild.get("petshop1aaata"));
    }

    /**
     * Inittablefilrs.
     *
     * @throws Exception the exception
     */
    @Test
    public void inittablefilrs() throws Exception {

//        TableAdaptor.getInstance().inittablefilrs(new File("database/petshop1/aaata.sql"));
    }

    /**
     * Gets instance.
     *
     * @throws Exception the exception
     */
    @Test
    public void getInstance() throws Exception {

    }

    /**
     * Droptable.
     *
     * @throws Exception the exception
     */
    @Test
    public void droptable() throws Exception {

        TableAdaptor.getInstance().droptable("petshop1", "aaata");
    }

    /**
     * Gets .
     *
     * @throws Exception the exception
     */
    @Test
    public void getfilepath() throws Exception {

    }

    /**
     * Createtable.
     *
     * @throws Exception the exception
     */
    @Test
    public void createtable() throws Exception {

        String sql = "create table aaata('id' int,name varchar)";
        MySqlStatementParser sqlStatementParser = new MySqlStatementParser(sql);
        List<SQLStatement> statements = sqlStatementParser.parseStatementList();
//        System.out.println(statements.get(0).toString());
        TableAdaptor.getInstance().createtable("petshop1", (MySqlCreateTableStatement) statements.get(0));

    }

}