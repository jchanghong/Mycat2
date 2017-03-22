package io.mycat.databaseorient;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import io.mycat.databaseorient.adapter.MDBadapter;
import io.mycat.databaseorient.adapter.MException;

/**
 * Created by 长宏 on 2017/3/20 0020.
 */
public class Test1 {
    public static void main(String[] args) throws MException {

        MDBadapter.currentDB = "db1";
        ODatabaseDocumentTx documentTx1 = MDBadapter.getCurrentDB();
        ODatabaseDocumentTx documentTx2 = MDBadapter.getCurrentDB();
        ODatabaseDocumentTx documentTx23 = MDBadapter.getCurrentDB();
        System.out.println(documentTx1==documentTx2);
        ODatabaseDocumentTx tx1 = MDBadapter.getCurrentDB();
        System.out.println(documentTx1==tx1);
        tx1.close();
//        MDBadapter.createdb(MDBadapter.currentDB);
//        MDBadapter.exesql("insert into t1(id) values(2);");
//        Object o = MDBadapter.exesql("insert into t1(id) values(2);");
//        System.out.println(o.toString());

    }

}
