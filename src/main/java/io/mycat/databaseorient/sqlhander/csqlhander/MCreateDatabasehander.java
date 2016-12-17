package io.mycat.databaseorient.sqlhander.csqlhander;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLCreateDatabaseStatement;
import io.mycat.databaseorient.adapter.DBadapter;
import io.mycat.databaseorient.sqlhander.AbstractSQLhander;

public class MCreateDatabasehander extends AbstractSQLhander{

    private static MCreateDatabasehander single = new MCreateDatabasehander(null);

    public static MCreateDatabasehander getInstance() {
        return single;
    }
    private MCreateDatabasehander(String databaseDocumentTx) {
        super(databaseDocumentTx);
    }

    @Override
    public boolean handerexe(SQLStatement sqlStatement) {
        SQLCreateDatabaseStatement statement = (SQLCreateDatabaseStatement) sqlStatement;
        return DBadapter.getInstance().createdb(statement.getName().getSimpleName());

    }
}
