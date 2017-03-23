package io.mycat.orientserver.handler.data_define;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlRenameTableStatement;
import com.orientechnologies.orient.core.db.OPartitionedDatabasePool;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import io.mycat.databaseorient.adapter.MDBadapter;
import io.mycat.databaseorient.adapter.MException;
import io.mycat.orientserver.OConnection;

import java.util.HashMap;
import java.util.Map;

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
    static Map<String, MException> map = new HashMap<>();
    public static void handle(MySqlRenameTableStatement x, OConnection connection) {
        if (MDBadapter.currentDB == null) {
            connection.writeErrMessage("没有选择数据库");
        }
        OPartitionedDatabasePool pool = MDBadapter.getdbpool(MDBadapter.currentDB);
        ODatabaseDocumentTx tx = pool.acquire();
        tx.activateOnCurrentThread();
        String oldname = x.getItems().get(0).getName().toString();
        String newname = x.getItems().get(0).getTo().toString();
        if (!tx.getMetadata().getSchema().existsClass(oldname)) {
            connection.writeErrMessage("表不存在");
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("ALTER CLASS ");
        builder.append(oldname);
        builder.append("  NAME ");
        builder.append(newname);
        map.clear();
            MDBadapter.executor.execute(() -> {
                try {
                    MDBadapter.exesql(builder.toString(),MDBadapter.currentDB);
                } catch (MException e) {
                    e.printStackTrace();
                    map.put("k", e);
                }
            });
        if (map.size() > 0) {
            connection.writeErrMessage(map.get("k").getMessage());
            return;
        }
        connection.writeok();
    }
}
