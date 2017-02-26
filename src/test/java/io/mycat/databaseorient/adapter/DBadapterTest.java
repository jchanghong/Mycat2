package io.mycat.databaseorient.adapter;

import com.orientechnologies.orient.core.db.OPartitionedDatabasePool;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiang on 2016/12/17 0017.
 */
public class DBadapterTest {
    /**
     * Exesql.
     *
     * @throws Exception the exception
     */
    @Test
    public void exesql() throws Exception {

    }

    /**
     * Exequery.
     *
     * @throws Exception the exception
     */
    @Test
    public void exequery() throws Exception {

        String sql = "select * from aaata";
        DBadapter.currentDB = "petshop1";
        List<Map<String, String>> list = DBadapter.getInstance().exequery(sql);
        System.out.println(list.size());
    }

    /**
     * Gets .
     *
     * @throws Exception the exception
     */
    @Test
    public void getfilepath() throws Exception {

        System.out.println(DBadapter.getInstance().getfilepath("db"));
    }

    /**
     * Deletedb.
     *
     * @throws Exception the exception
     */
    @Test
    public void deletedb() throws Exception {

        DBadapter.getInstance().deletedb("db");
    }

    /**
     * Createdb.
     *
     * @throws Exception the exception
     */
    @Test
    public void createdb() throws Exception {

        DBadapter dBadapter = DBadapter.getInstance();
        int si = dBadapter.getalldbnames().size();
        boolean db = dBadapter.createdb("db");
        if (db) {

            assertEquals(si+1, dBadapter.hashMap.size());
        }
    }

    /**
     * Gets .
     *
     * @throws Exception the exception
     */
    @Test
    public void getalldbnames() throws Exception {

        List<String> list = DBadapter.getInstance().getalldbnames();
        assertEquals(2, list.size());
        System.out.println(list.get(0).toString());
    }

    /**
     * Gets .
     *
     * @throws Exception the exception
     */
    @Test
    public void getmemoryurl() throws Exception {

        assertEquals("memory:database/hello",DBadapter.getInstance().getmemoryurl("hello"));
    }

    /**
     * Gets .
     *
     * @throws Exception the exception
     */
    @Test
    public void getlccalurl() throws Exception {

    }

    /**
     * Testorint.
     *
     * @throws Exception the exception
     */
    @Test
    public void testorint() throws Exception {
        OPartitionedDatabasePool pool = new OPartitionedDatabasePool("plocal:database/petshop3", "admin", "admin");
        ODatabaseDocumentTx databaseDocumentTx = null;
        try {
            databaseDocumentTx = pool.acquire();
        } catch (Exception e) {
            System.out.println("dddddd");
//            e.printStackTrace();
        }
        System.out.println("dddd");
        databaseDocumentTx.close();

    }

    /**
     * Gets instance.
     *
     * @throws Exception the exception
     */
    @Test
    public void getInstance() throws Exception {

    }

    /**
     * Gets .
     *
     * @throws Exception the exception
     */
    @Test
    public void getdbnamefromurl() throws Exception {

        assertEquals("hello",DBadapter.getInstance().getdbnamefromurl("local:data/hello"));
    }

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {

    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
    public void tearDown() throws Exception {

    }

}