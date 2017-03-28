package io.mycat.orientserver.handler.utilstatement;

import com.alibaba.druid.sql.ast.statement.SQLExplainStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlHelpStatement;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OProperty;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.impl.ODocument;
import io.mycat.backend.mysql.PacketUtil;
import io.mycat.config.ErrorCode;
import io.mycat.config.Fields;
import io.mycat.databaseorient.adapter.MDBadapter;
import io.mycat.databaseorient.adapter.MException;
import io.mycat.databaseorient.sqlhander.sqlutil.MSQLutil;
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
 * Created by 讯 on 2017/3/27.
 */
public class ExplainStatement {
    public static boolean isme(String sql,OConnection c) {
        String sqll = sql.toUpperCase().trim();
        String list[] = sqll.split("\\s+");
        if (list.length > 1 && list[0].equals("EXPLAIN")) {
            return true;
        }
        else if(list.length > 2 && list[0].equals("EXPLAIN")){
            return ExplainStatement.handle2(sql,c);
        }
        return false;
    }
/*
explain select*from tb_name
 */
    private static boolean handle2(String sql, OConnection c) {
        return false;
    }
/*
explain table完成
 */
    public static void handle(String statement, OConnection c) {
        if (MDBadapter.currentDB == null) {
            c.writeErrMessage(ErrorCode.ER_NO_DB_ERROR, "no database selected!!");
            return;
        }

String stmt=statement.toString();
        int FIELD_COUNT;
        ResultSetHeaderPacket header;
        FieldPacket[] fields;
        EOFPacket eof;
        List<String> selects;
        /*
        List<ODocument> data;
        try {
            data = MDBadapter.exequery(stmt,MDBadapter.currentDB);
        } catch (MException e) {
            e.printStackTrace();
            c.writeErrMessage(ErrorCode.ERR_HANDLE_DATA, e.getMessage());
            return;
        }*/
        ODatabaseDocumentTx documentTx = MDBadapter.getCurrentDB();
        String sqll = stmt.trim();
        String list[] = sqll.split("\\s+");//以空格分隔开字符串取出tablename适用于explain tb_name不适用于explain select*from tb_name
        OClass oClass = documentTx.getMetadata().getSchema().getClass(list[1]);

        if (oClass == null) {
            c.writeErrMessage(ErrorCode.ERR_HANDLE_DATA, "error");
            documentTx.close();
            return;
        }
        List<OProperty> pro = new ArrayList<>();
        oClass.properties().forEach(a -> pro.add(a));

        //selects = MSQLutil.gettablenamefileds(stmt);

        FIELD_COUNT = 6;
        header = PacketUtil.getHeader(FIELD_COUNT);
        fields = new FieldPacket[FIELD_COUNT];
        int i = 0;
        byte packetId = 0;
        header.packetId = ++packetId;
        fields[0]=PacketUtil.getField("Field",Fields.FIELD_TYPE_VAR_STRING);
        fields[i++].packetId=++packetId;
        fields[1]=PacketUtil.getField("Type",Fields.FIELD_TYPE_VAR_STRING);
        fields[i++].packetId=++packetId;
        fields[2]=PacketUtil.getField("Null",Fields.FIELD_TYPE_VAR_STRING);
        fields[i++].packetId=++packetId;
        fields[3]=PacketUtil.getField("Key",Fields.FIELD_TYPE_VAR_STRING);
        fields[i++].packetId=++packetId;
        fields[4]=PacketUtil.getField("Default",Fields.FIELD_TYPE_VAR_STRING);
        fields[i++].packetId=++packetId;
        fields[5]=PacketUtil.getField("Extra",Fields.FIELD_TYPE_VAR_STRING);
        fields[i++].packetId=++packetId;

/*
        for (OProperty string : oClass.properties()) {
            if (selects.contains(string.getName())) {
                fields[i] = PacketUtil.getField(string.getName(), Fields.FIELD_TYPE_VAR_STRING);
                fields[i++].packetId = ++packetId;
            }
        }
        */
        eof = new EOFPacket();
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
for(OProperty name :pro){
    RowDataPacket row = new RowDataPacket(FIELD_COUNT);
    row.add(StringUtil.encode(name.getName(),c.getCharset()));
    row.add(StringUtil.encode(name.getType().toString(),c.getCharset()));
    row.add(StringUtil.encode(name.isNotNull()?"No":"Yes",c.getCharset()));
    row.add(StringUtil.encode("  ",c.getCharset()));
    row.add(StringUtil.encode("Null ",c.getCharset()));
    row.add(StringUtil.encode("  ",c.getCharset()));
    row.packetId = ++packetId;
    buffer = row.write(buffer, c, true);
}
/*


        for (ODocument name : data) {
            RowDataPacket row = new RowDataPacket(FIELD_COUNT);
            selects.forEach(a -> {
                row.add(StringUtil.encode(name.field(a)==null?"null":name.field(a).toString(), c.getCharset()));
            });
            row.packetId = ++packetId;
            buffer = row.write(buffer, c, true);
        }*/
        // write last eof
        EOFPacket lastEof = new EOFPacket();
        lastEof.packetId = ++packetId;
        buffer = lastEof.write(buffer, c, true);
        // post write
        c.write(buffer);
        documentTx.close();
    }


}
