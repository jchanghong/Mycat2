package io.mycat.databaseorient.sqlhander;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.orientechnologies.orient.core.record.impl.ODocument;

import java.util.List;

public interface SQLHander {

    boolean handerexe(SQLStatement sqlStatement);

    List<ODocument> handerquery(SQLStatement sqlStatement);
}
