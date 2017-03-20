package io.mycat.databaseorient;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OClassImpl;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.impl.ODocument;

/**
 * Created by 长宏 on 2017/3/20 0020.
 */
public class Test1 {
    public static void main(String[] args) {
        ODatabaseDocumentTx db = new ODatabaseDocumentTx
                ("plocal:database/db")
                .open("admin", "admin");
        OClass oClass = db.getMetadata().getSchema().getClass("test1");
//        oClass.createProperty("id", OType.INTEGER);
//        oClass.setStrictMode(true);
        ODocument animal = new ODocument("test1");
        animal.field("id", "66");
        animal.save();
        oClass.properties().forEach(a->System.out.println(a.getName()));
    }

}
