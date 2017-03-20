package io.mycat.orientserver.handler.data_define;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlRenameTableStatement;
import io.mycat.databaseorient.adapter.DBadapter;
import io.mycat.databaseorient.adapter.MException;
import io.mycat.databaseorient.adapter.TableAdaptor;
import io.mycat.orientserver.OConnection;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by 长宏 on 2017/3/18 0018.
 * For example, a table named old_table can be renamed to new_table as shown here:

 RENAME TABLE old_table TO new_table;
 This statement is equivalent to the following ALTER TABLE statement:

 ALTER TABLE old_table RENAME new_table;


 --------------------------
 Update the class name from Account to Seller :
 orientdb> ALTER CLASS Account NAME Seller
 */
public class RenameTable {
    public static void handle(MySqlRenameTableStatement x, OConnection connection) {
        if (DBadapter.currentDB == null) {
            connection.writeErrMessage("没有选择数据库");
        }
       DBadapter.executor.execute(() -> handleme(x, connection));
        connection.writeok();
    }
    private static void handleme(MySqlRenameTableStatement x, OConnection connection) {
        MySqlRenameTableStatement.Item item = x.getItems().get(0);
        String oldname = item.getName().toString();
        String newname = item.getTo().toString();
        File old = new File(TableAdaptor.getInstance().getfilepath(DBadapter.currentDB, oldname));
        File newfile = new File(TableAdaptor.getInstance().getfilepath(DBadapter.currentDB, newname));
        old.renameTo(newfile);
        try {
            String content = FileCopyUtils.copyToString(new FileReader(newfile));
            content = content.replace(oldname, newname);
            FileCopyUtils.copy(content, new FileWriter(newfile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //orientdb> ALTER CLASS Account NAME Seller
        String orient = "ALTER CLASS  " + oldname + "  NAME " + newname;
        try {
            DBadapter.getInstance().exesql(orient);
        } catch (MException e) {
            e.printStackTrace();
        }
        TableAdaptor.getInstance().reload(oldname, newname);
    }
}
