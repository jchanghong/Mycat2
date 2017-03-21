package io.mycat.databaseorient;

import com.orientechnologies.orient.core.record.impl.ODocument;
import io.mycat.databaseorient.adapter.MDBadapter;
import io.mycat.databaseorient.adapter.MException;

import java.util.List;

/**
 * Created by 长宏 on 2017/3/20 0020.
 */
public class Test1 {
    public static void main(String[] args) throws MException {

        MDBadapter.currentDB = "db";
        MDBadapter.createdb("db6");
        List<ODocument> list = MDBadapter.exequery("select * from test1");
        list.forEach(a -> System.out.println(a.toString()));

    }

}
