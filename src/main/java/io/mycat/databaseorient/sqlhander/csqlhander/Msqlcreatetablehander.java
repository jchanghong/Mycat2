package io.mycat.databaseorient.sqlhander.csqlhander;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlCreateTableStatement;
import io.mycat.databaseorient.adapter.TableAdaptor;
import io.mycat.databaseorient.sqlhander.AbstractSQLhander;

public class Msqlcreatetablehander extends AbstractSQLhander{
    private static Msqlcreatetablehander single=new Msqlcreatetablehander(null);

    public static Msqlcreatetablehander getInstance() {
        return single;
    }
    private Msqlcreatetablehander(String databaseDocumentTx) {
        super(databaseDocumentTx);
    }

    @Override
    public boolean handerexe(SQLStatement sqlStatement) {
        return TableAdaptor.getInstance().createtable(dbname, (MySqlCreateTableStatement) sqlStatement);
    }
}
