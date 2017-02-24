package io.mycat;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;

/**
 * Created by 长宏 on 2017/2/23 0023.
 */
public class TestOrientDB {
    public static void main(String[] args) {
        ODatabaseDocumentTx db = new ODatabaseDocumentTx
                ("plocal:database/changhong")
                .open("admin", "admin");
        ODocument animal = new ODocument("t1");
        animal.field("id", "66");
        animal.save();
    }

}
