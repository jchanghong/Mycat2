package io.mycat.orientserver.response;

import io.mycat.backend.mysql.PacketUtil;
import io.mycat.config.ErrorCode;
import io.mycat.config.Fields;
import io.mycat.databaseorient.adapter.DBadapter;
import io.mycat.databaseorient.adapter.TableAdaptor;
import io.mycat.net.mysql.EOFPacket;
import io.mycat.net.mysql.FieldPacket;
import io.mycat.net.mysql.ResultSetHeaderPacket;
import io.mycat.net.mysql.RowDataPacket;
import io.mycat.orientserver.OConnection;
import io.mycat.orientserver.util.SchemaUtil;
import io.mycat.util.StringUtil;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * show tables impl
 *
 * @author yanglixue
 */
public class ShowTables {

    private static final int FIELD_COUNT = 1;
    private static final ResultSetHeaderPacket header = PacketUtil.getHeader(FIELD_COUNT);
    private static final FieldPacket[] fields = new FieldPacket[FIELD_COUNT];
    private static final EOFPacket eof = new EOFPacket();

//    private static final String SCHEMA_KEY = "schemaName";
//    private static final String LIKE_KEY = "like";
//    private static final Pattern pattern = Pattern.compile("^\\s*(SHOW)\\s+(TABLES)(\\s+(FROM)\\s+([a-zA-Z_0-9]+))?(\\s+(LIKE\\s+'(.*)'))?\\s*", Pattern.CASE_INSENSITIVE);

    /**
     * response method.
     *
     * @param c
     */
    public static void response(OConnection c, String stmt, int type) {
        if (DBadapter.currentDB == null) {
            c.writeErrMessage(ErrorCode.ER_NO_DB_ERROR, "no database selected!!!");
            return;
        }
        int i = 0;
        byte packetId = 0;
        header.packetId = ++packetId;
        fields[i] = PacketUtil.getField("Tables in " + c.getSchema(), Fields.FIELD_TYPE_VAR_STRING);
        fields[i++].packetId = ++packetId;
        eof.packetId = ++packetId;
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
        packetId = eof.packetId;

        for (String name : TableAdaptor.getInstance().hashMapdb2table.get(DBadapter.currentDB)) {
            RowDataPacket row = new RowDataPacket(FIELD_COUNT);
            row.add(StringUtil.encode(name.toLowerCase(), c.getCharset()));
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
}
