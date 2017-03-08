package io.mycat.orientserver.handler.utilstatement;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlHelpStatement;
import io.mycat.backend.mysql.PacketUtil;
import io.mycat.config.ErrorCode;
import io.mycat.databaseorient.adapter.DBadapter;
import io.mycat.net.AbstractConnection;
import io.mycat.net.mysql.*;
import io.mycat.orientserver.OConnection;
import io.mycat.orientserver.response.Select1Response;
import io.mycat.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.util.Arrays;

import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.header;
import static io.mycat.net.mysql.EOFPacket.FIELD_COUNT;

/**
 * Created by 长宏 on 2017/2/25 0025.
 */
public class HelpStatement {

    public static void handle(MySqlHelpStatement x, OConnection c) {


        String helpstatment = x.toString();
        if (helpstatment.contains("use")) {
            //c.writeErrMessage(ErrorCode.ER_UNKNOWN_COM_ERROR, "The USE db_name statement tells MySQL to use the db_name database as the default (current) database for subsequent statements. ");
       //   c.writeErrMessage(ErrorCode.ER_UNKNOWN_COM_ERROR, "Unsuppoted Message ");

//        c.writeOkMessage("hello");


            Select1Response.response(c, "help use", Arrays.asList("use database ,比如use db;"));
            return;
        }
        if (helpstatment.contains("show")) {
            Select1Response.response(c, "help show", Arrays.asList("SHOW DATABASES [LIKE wild]\n" +
                    "or SHOW TABLES [FROM db_name] [LIKE wild]\n" +
                    "or SHOW COLUMNS FROM tbl_name [FROM db_name] [LIKE wild]\n" +
                    "or SHOW INDEX FROM tbl_name [FROM db_name]\n" +
                    "or SHOW STATUS\n" +
                    "or SHOW VARIABLES [LIKE wild]\n" +
                    "or SHOW [FULL] PROCESSLIST\n" +
                    "or SHOW TABLE STATUS [FROM db_name] [LIKE wild]\n" +
                    "or SHOW GRANTS FOR user\n" +
                    "\n" +
                    "SHOW提供关于数据库、表、列或服务器的信息。如果使用LIKE wild部分，wild字符串可以是一个使用SQL的“%”和“_”通配符的字符串。\n"));

            return;
        }
        if (helpstatment.contains("select")) {
            Select1Response.response(c, "help select", Arrays.asList("SELECT [STRAIGHT_JOIN] [SQL_SMALL_RESULT] [SQL_BIG_RESULT] [HIGH_PRIORITY]\n" +
                    "       [DISTINCT | DISTINCTROW | ALL]\n" +
                    "    select_expression,...\n" +
                    "    [INTO {OUTFILE | DUMPFILE} 'file_name' export_options]\n" +
                    "    [FROM table_references\n" +
                    "        [WHERE where_definition]\n" +
                    "        [GROUP BY col_name,...]\n" +
                    "        [HAVING where_definition]\n" +
                    "        [ORDER BY {unsigned_integer | col_name | formula} [ASC | DESC] ,...]\n" +
                    "        [LIMIT [offset,] rows]\n" +
                    "        [PROCEDURE procedure_name] ]\n" +
                    "\n" +
                    "SELECT被用来检索从一个或多个表中精选的行。select_expression指出你想要检索的列。SELECT也可以用来检索不引用任何表的计算行。\n"));
            return;
        }
        if (helpstatment.contains("create")) {
            Select1Response.response(c, "help create", Arrays.asList("CREATE DATABASE db_name CREATE DATABASE用给定的名字创建一个数据库。\n"+"CREATE [TEMPORARY] TABLE [IF NOT EXISTS] tbl_name [(create_definition,...)]\n" +
                    "[table_options] [select_statement\nCREATE TABLE在当前数据库中用给出的名字创建一个数据库表。\n"+"CREATE INDEX被映射到一个ALTER TABLE语句来创建索引。\n"+"CREATE [AGGREGATE] FUNCTION function_name RETURNS {STRING|REAL|INTEGER}\n" +
                    "       SONAME shared_library_name\n"+"CREATE FUNCTION在mysql.func系统表中保存函数名、类型和共享库名。"));
            return;
        }
        if (helpstatment.contains("insert")) {
            Select1Response.response(c, "help insert", Arrays.asList("INSERT [LOW_PRIORITY | DELAYED] [IGNORE]\n" +
                    "        [INTO] tbl_name [(col_name,...)]\n" +
                    "        VALUES (expression,...),(...),...\n" +
                    "或  INSERT [LOW_PRIORITY | DELAYED] [IGNORE]\n" +
                    "        [INTO] tbl_name [(col_name,...)]\n" +
                    "        SELECT ...\n" +
                    "或  INSERT [LOW_PRIORITY | DELAYED] [IGNORE]\n" +
                    "        [INTO] tbl_name\n" +
                    "        SET col_name=expression, col_name=expression, ...\n" +
                    "\n" +
                    "INSERT把新行插入到一个存在的表中，INSERT ... VALUES形式的语句基于明确指定的值插入行，INSERT ... SELECT形式插入从其他表选择的行，有多个值表的INSERT ... VALUES的形式在MySQL 3.22.5或以后版本中支持，col_name=expression语法在MySQL 3.22.10或以后版本中支持。 \n" +
                    "\n" +
                    "tbl_name是行应该被插入其中的表。列名表或SET子句指出语句为那一列指定值。 \n" +
                    "\n"));
            return;
        }
        if (helpstatment.contains("alter")) {
            Select1Response.response(c, "help alter", Arrays.asList("ALTER [IGNORE] TABLE tbl_name alter_spec [, alter_spec ...]\n" +
                    "\n" +
                    "alter_specification:\n" +
                    "        ADD [COLUMN] create_definition [FIRST | AFTER column_name ]\n" +
                    "  or    ADD INDEX [index_name] (index_col_name,...)\n" +
                    "  or    ADD PRIMARY KEY (index_col_name,...)\n" +
                    "  or    ADD UNIQUE [index_name] (index_col_name,...)\n" +
                    "  or    ALTER [COLUMN] col_name {SET DEFAULT literal | DROP DEFAULT}\n" +
                    "  or    CHANGE [COLUMN] old_col_name create_definition\n" +
                    "  or    MODIFY [COLUMN] create_definition\n" +
                    "  or    DROP [COLUMN] col_name\n" +
                    "  or    DROP PRIMARY KEY\n" +
                    "  or    DROP INDEX index_name\n" +
                    "  or    RENAME [AS] new_tbl_name\n" +
                    "  or    table_options\n" +
                    "\n" +
                    "ALTER TABLE允许你修改一个现有表的结构。例如，你可以增加或删除列、创造或消去索引、改变现有列的类型、或重新命名列或表本身。你也能改变表的注释和表的类型。\n"));
            return;
        }
    }
}
