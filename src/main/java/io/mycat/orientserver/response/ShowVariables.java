package io.mycat.orientserver.response;

import io.mycat.backend.mysql.PacketUtil;
import io.mycat.config.Fields;
import io.mycat.databaseorient.adapter.DBadapter;
import io.mycat.net.mysql.EOFPacket;
import io.mycat.net.mysql.FieldPacket;
import io.mycat.net.mysql.ResultSetHeaderPacket;
import io.mycat.net.mysql.RowDataPacket;
import io.mycat.orientserver.OConnection;
import io.mycat.util.StringUtil;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiang on 2017/2/26 0026.
 *
 */
public class ShowVariables {

    private static final int FIELD_COUNT = 2;
    private static final ResultSetHeaderPacket header = PacketUtil.getHeader(FIELD_COUNT);
    private static final FieldPacket[] fields = new FieldPacket[FIELD_COUNT];
    private static final EOFPacket eof = new EOFPacket();

    static {
        int i = 0;
        byte packetId = 0;
        header.packetId = ++packetId;
        fields[i] = PacketUtil.getField("variable", Fields.FIELD_TYPE_VAR_STRING);
        fields[i++].packetId = ++packetId;
        fields[i] = PacketUtil.getField("values", Fields.FIELD_TYPE_VAR_STRING);
        fields[i++].packetId = ++packetId;
        eof.packetId = ++packetId;
    }

    public static void response(OConnection c) {
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

        for (Map.Entry<String,String> name : variables.entrySet()) {
            RowDataPacket row = new RowDataPacket(FIELD_COUNT);
            row.add(StringUtil.encode(name.getKey(), c.getCharset()));
            row.add(StringUtil.encode(name.getValue(), c.getCharset()));
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
    private static final Map<String, String> variables = new HashMap<String, String>();

    static {
        variables.put("@@character_set_client", "utf8");
        variables.put("@@character_set_connection", "utf8");
        variables.put("@@character_set_results", "utf8");
        variables.put("@@character_set_server", "utf8");
        variables.put("@@init_connect", "");
        variables.put("@@interactive_timeout", "172800");
        variables.put("@@license", "GPL");
        variables.put("@@lower_case_table_names", "1");
        variables.put("@@max_allowed_packet", "16777216");
        variables.put("@@net_buffer_length", "16384");
        variables.put("@@net_write_timeout", "60");
        variables.put("@@query_cache_size", "0");
        variables.put("@@query_cache_type", "OFF");
        variables.put("@@sql_mode", "STRICT_TRANS_TABLES");
        variables.put("@@system_time_zone", "CST");
        variables.put("@@time_zone", "SYSTEM");
        variables.put("@@tx_isolation", "REPEATABLE-READ");
        variables.put("@@wait_timeout", "172800");
        variables.put("@@session.auto_increment_increment", "1");

        variables.put("character_set_client", "utf8");
        variables.put("character_set_connection", "utf8");
        variables.put("character_set_results", "utf8");
        variables.put("character_set_server", "utf8");
        variables.put("init_connect", "");
        variables.put("interactive_timeout", "172800");
        variables.put("license", "GPL");
        variables.put("lower_case_table_names", "1");
        variables.put("max_allowed_packet", "16777216");
        variables.put("net_buffer_length", "16384");
        variables.put("net_write_timeout", "60");
        variables.put("query_cache_size", "0");
        variables.put("query_cache_type", "OFF");
        variables.put("sql_mode", "STRICT_TRANS_TABLES");
        variables.put("system_time_zone", "CST");
        variables.put("time_zone", "SYSTEM");
        variables.put("tx_isolation", "REPEATABLE-READ");
        variables.put("wait_timeout", "172800");
        variables.put("auto_increment_increment", "1");
    }


}
