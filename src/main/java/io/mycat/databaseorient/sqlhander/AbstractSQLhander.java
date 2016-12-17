package io.mycat.databaseorient.sqlhander;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.orientechnologies.orient.core.record.impl.ODocument;

import java.util.List;

public class AbstractSQLhander implements SQLHander {
    protected String dbname;

    public AbstractSQLhander(String dbname) {
        this.dbname = dbname;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    @Override
    public boolean handerexe(SQLStatement sqlStatement) {
        return false;
    }

    @Override
    public List<ODocument> handerquery(SQLStatement sqlStatement) {
        return null;
    }
}
