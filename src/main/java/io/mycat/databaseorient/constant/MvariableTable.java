package io.mycat.databaseorient.constant;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.impl.ODocument;
import io.mycat.databaseorient.adapter.MDBadapter;

/**
 * Created by 长宏 on 2017/3/23 0023.
 * Variable_name  value
 */
public class MvariableTable {
  public   final static String tablename = "variables";
  public   final static String tablenamestatus = "status";

    public static void init_if_notexits() {
        ODatabaseDocumentTx documentTx = MDBadapter.getCurrentDB(Minformation_schama.dbname);
        if (documentTx.getMetadata().getSchema().existsClass(tablename)) {
            documentTx.close();
            return;
        }
        else {
            OClass oClass = documentTx.getMetadata().getSchema().createClass(tablename);
            OClass oClass1 = documentTx.getMetadata().getSchema().createClass(tablenamestatus);
            oClass.setStrictMode(true);
            oClass.createProperty("Variable_name", OType.STRING);
            oClass.createProperty("value", OType.STRING);
            oClass1.setStrictMode(true);
            oClass1.createProperty("Variable_name", OType.STRING);
            oClass1.createProperty("value", OType.STRING);
            Mconstantvariables.MAP.entrySet().forEach(e->{
                ODocument document = new ODocument(tablename);
                document.field("Variable_name", e.getKey());
                document.field("value", e.getValue());
                document.save();
            });
            MconstantStatusVariables.MAP.entrySet().forEach(e->{
                ODocument document = new ODocument(tablenamestatus);
                document.field("Variable_name", e.getKey());
                document.field("value", e.getValue());
                document.save();
            });
            documentTx.close();
        }
    }
}
