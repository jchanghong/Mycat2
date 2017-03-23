package io.mycat.orientserver.handler.data_mannipulation;

import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import com.orientechnologies.orient.core.record.impl.ODocument;
import io.mycat.backend.mysql.PacketUtil;
import io.mycat.config.Fields;
import io.mycat.databaseorient.adapter.MDBadapter;
import io.mycat.databaseorient.adapter.MException;
import io.mycat.databaseorient.adapter.MtableAdapter;
import io.mycat.databaseorient.constant.Minformation_schama;
import io.mycat.databaseorient.constant.MvariableTable;
import io.mycat.net.mysql.EOFPacket;
import io.mycat.net.mysql.FieldPacket;
import io.mycat.net.mysql.ResultSetHeaderPacket;
import io.mycat.net.mysql.RowDataPacket;
import io.mycat.orientserver.OConnection;
import io.mycat.util.StringUtil;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 长宏 on 2017/3/23 0023.
 */
public class MselectVariables {

    private static final int FIELD_COUNT = 2;
    private static final ResultSetHeaderPacket header = PacketUtil.getHeader(FIELD_COUNT);
    private static final FieldPacket[] fields = new FieldPacket[FIELD_COUNT];
    private static final EOFPacket eof = new EOFPacket();

    static {
        int i = 0;
        byte packetId = 0;
        header.packetId = ++packetId;
        fields[i] = PacketUtil.getField("Variable_name", Fields.FIELD_TYPE_VAR_STRING);
        fields[i++].packetId = ++packetId;
        fields[i] = PacketUtil.getField("values", Fields.FIELD_TYPE_VAR_STRING);
        fields[i++].packetId = ++packetId;
        eof.packetId = ++packetId;
    }

    /**
     * Handle.
     *
     * @param c         the c
     * @param statement the statement 一定是show variables 或者select @@这样的语句
     *                  然后变成select * from variables
     */
    public static void handle(OConnection c, String statement) {
        ByteBuffer buffer = c.allocate();

        // write header
        buffer = header.write(buffer, c, true);

        // write fields
        for (FieldPacket field : fields) {
            buffer = field.write(buffer, c, true);
        }

        // write eof
        buffer = eof.write(buffer, c, true);

        // write rows
        byte packetId = eof.packetId;
        List<ODocument> datas;
        try {
            datas = MDBadapter.exequery(statement, Minformation_schama.dbname);
        } catch (MException e) {
            e.printStackTrace();
            c.writeErrMessage(e.getMessage());
            return;
        }
        for (ODocument name : datas) {
            RowDataPacket row = new RowDataPacket(FIELD_COUNT);
            row.add(StringUtil.encode(name.field("Variable_name"), c.getCharset()));
            row.add(StringUtil.encode(name.field("value"), c.getCharset()));
            row.packetId = ++packetId;
            buffer = row.write(buffer, c, true);
        }
        // write last eof
        EOFPacket lastEof = new EOFPacket();
        lastEof.packetId = ++packetId;
        buffer = lastEof.write(buffer, c, true);
        // post write
        c.write(buffer);
    }

    public static List<String> getcolumn(SQLSelectStatement selectStatement) {
        MySqlSelectQueryBlock block = (MySqlSelectQueryBlock) selectStatement.getSelect().getQuery();
        List<SQLSelectItem> items = block.getSelectList();
        List<String> list = new ArrayList<>();
        items.forEach(a -> list.add(a.getAlias()));
        return list;
    }

    public static List<String> getbs(SQLSelectStatement selectStatement, List<String> column) {
        try {
            List<ODocument> datas = MDBadapter.exequery("select * from " + MvariableTable.tablename, Minformation_schama.dbname);
            List<String> list = new ArrayList<>(column.size());
            for (String c:
                 column) {
                list.add(getv(datas, c));
            }
            return list;
        } catch (MException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getv(List<ODocument> datas, String c) {
        for (ODocument d :
                datas) {
            if (d.field("Variable_name").equals(c)) {
                return d.field("value");
            }
            }
        return null;
    }
}
