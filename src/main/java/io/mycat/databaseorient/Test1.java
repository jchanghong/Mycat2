package io.mycat.databaseorient;

import io.mycat.databaseorient.adapter.MDBadapter;
import io.mycat.databaseorient.adapter.MException;

/**
 * Created by 长宏 on 2017/3/20 0020.
 */
public class Test1 {
    public static void main(String[] args) throws MException {

        MDBadapter.currentDB = "db3";
//        MDBadapter.createdb(MDBadapter.currentDB);
        MDBadapter.exesql("insert into t1(id) values(2);");
        Object o = MDBadapter.exesql("insert into t1(id) values(2);");
        System.out.println(o.toString());

    }

}
