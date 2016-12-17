package io.mycat.databaseorient.sqlhander;

import com.alibaba.druid.sql.ast.*;
import com.alibaba.druid.sql.ast.expr.*;
import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.ast.*;
import com.alibaba.druid.sql.dialect.mysql.ast.clause.*;
import com.alibaba.druid.sql.dialect.mysql.ast.expr.*;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlASTVisitor;
import io.mycat.databaseorient.Log;
import io.mycat.databaseorient.adapter.DBadapter;
import io.mycat.databaseorient.sqlhander.csqlhander.MCreateDatabasehander;
import io.mycat.databaseorient.sqlhander.csqlhander.Msqlcreatetablehander;

public class SQLvisitor implements MySqlASTVisitor ,Log{
    @Override
    public boolean visit(MySqlSelectQueryBlock.Limit limit) {
        return false;
    }

    @Override
    public void endVisit(MySqlSelectQueryBlock.Limit limit) {

    }

    @Override
    public boolean visit(MySqlTableIndex mySqlTableIndex) {
        return false;
    }

    @Override
    public void endVisit(MySqlTableIndex mySqlTableIndex) {

    }

    @Override
    public boolean visit(MySqlKey mySqlKey) {
        return false;
    }

    @Override
    public void endVisit(MySqlKey mySqlKey) {

    }

    @Override
    public boolean visit(MySqlPrimaryKey mySqlPrimaryKey) {
        return false;
    }

    @Override
    public void endVisit(MySqlPrimaryKey mySqlPrimaryKey) {

    }

    @Override
    public boolean visit(MySqlUnique mySqlUnique) {
        return false;
    }

    @Override
    public void endVisit(MySqlUnique mySqlUnique) {

    }

    @Override
    public boolean visit(MysqlForeignKey mysqlForeignKey) {
        return false;
    }

    @Override
    public void endVisit(MysqlForeignKey mysqlForeignKey) {

    }

    @Override
    public void endVisit(MySqlIntervalExpr mySqlIntervalExpr) {

    }

    @Override
    public boolean visit(MySqlIntervalExpr mySqlIntervalExpr) {
        return false;
    }

    @Override
    public void endVisit(MySqlExtractExpr mySqlExtractExpr) {

    }

    @Override
    public boolean visit(MySqlExtractExpr mySqlExtractExpr) {
        return false;
    }

    @Override
    public void endVisit(MySqlMatchAgainstExpr mySqlMatchAgainstExpr) {

    }

    @Override
    public boolean visit(MySqlMatchAgainstExpr mySqlMatchAgainstExpr) {
        return false;
    }

    @Override
    public void endVisit(MySqlPrepareStatement mySqlPrepareStatement) {

    }

    @Override
    public boolean visit(MySqlPrepareStatement mySqlPrepareStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlExecuteStatement mySqlExecuteStatement) {

    }

    @Override
    public boolean visit(MysqlDeallocatePrepareStatement mysqlDeallocatePrepareStatement) {
        return false;
    }

    @Override
    public void endVisit(MysqlDeallocatePrepareStatement mysqlDeallocatePrepareStatement) {

    }

    @Override
    public boolean visit(MySqlExecuteStatement mySqlExecuteStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlDeleteStatement mySqlDeleteStatement) {

    }

    @Override
    public boolean visit(MySqlDeleteStatement mySqlDeleteStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlInsertStatement mySqlInsertStatement) {

    }

    @Override
    public boolean visit(MySqlInsertStatement mySqlInsertStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlLoadDataInFileStatement mySqlLoadDataInFileStatement) {

    }

    @Override
    public boolean visit(MySqlLoadDataInFileStatement mySqlLoadDataInFileStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlLoadXmlStatement mySqlLoadXmlStatement) {

    }

    @Override
    public boolean visit(MySqlLoadXmlStatement mySqlLoadXmlStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlReplaceStatement mySqlReplaceStatement) {

    }

    @Override
    public boolean visit(MySqlReplaceStatement mySqlReplaceStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlStartTransactionStatement mySqlStartTransactionStatement) {

    }

    @Override
    public boolean visit(MySqlStartTransactionStatement mySqlStartTransactionStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlCommitStatement mySqlCommitStatement) {

    }

    @Override
    public boolean visit(MySqlCommitStatement mySqlCommitStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlRollbackStatement mySqlRollbackStatement) {

    }

    @Override
    public boolean visit(MySqlRollbackStatement mySqlRollbackStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowColumnsStatement mySqlShowColumnsStatement) {

    }

    @Override
    public boolean visit(MySqlShowColumnsStatement mySqlShowColumnsStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowDatabasesStatement mySqlShowDatabasesStatement) {

    }

    @Override
    public boolean visit(MySqlShowDatabasesStatement mySqlShowDatabasesStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowWarningsStatement mySqlShowWarningsStatement) {

    }

    @Override
    public boolean visit(MySqlShowWarningsStatement mySqlShowWarningsStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowStatusStatement mySqlShowStatusStatement) {

    }

    @Override
    public boolean visit(MySqlShowStatusStatement mySqlShowStatusStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowAuthorsStatement mySqlShowAuthorsStatement) {

    }

    @Override
    public boolean visit(MySqlShowAuthorsStatement mySqlShowAuthorsStatement) {
        return false;
    }

    @Override
    public void endVisit(CobarShowStatus cobarShowStatus) {

    }

    @Override
    public boolean visit(CobarShowStatus cobarShowStatus) {
        return false;
    }

    @Override
    public void endVisit(MySqlKillStatement mySqlKillStatement) {

    }

    @Override
    public boolean visit(MySqlKillStatement mySqlKillStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlBinlogStatement mySqlBinlogStatement) {

    }

    @Override
    public boolean visit(MySqlBinlogStatement mySqlBinlogStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlResetStatement mySqlResetStatement) {

    }

    @Override
    public boolean visit(MySqlResetStatement mySqlResetStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlCreateUserStatement mySqlCreateUserStatement) {

    }

    @Override
    public boolean visit(MySqlCreateUserStatement mySqlCreateUserStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlCreateUserStatement.UserSpecification userSpecification) {

    }

    @Override
    public boolean visit(MySqlCreateUserStatement.UserSpecification userSpecification) {
        return false;
    }

    @Override
    public void endVisit(MySqlPartitionByKey mySqlPartitionByKey) {

    }

    @Override
    public boolean visit(MySqlPartitionByKey mySqlPartitionByKey) {
        return false;
    }

    @Override
    public boolean visit(MySqlSelectQueryBlock mySqlSelectQueryBlock) {
        return false;
    }

    @Override
    public void endVisit(MySqlSelectQueryBlock mySqlSelectQueryBlock) {

    }

    @Override
    public boolean visit(MySqlOutFileExpr mySqlOutFileExpr) {
        return false;
    }

    @Override
    public void endVisit(MySqlOutFileExpr mySqlOutFileExpr) {

    }

    @Override
    public boolean visit(MySqlDescribeStatement mySqlDescribeStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlDescribeStatement mySqlDescribeStatement) {

    }

    @Override
    public boolean visit(MySqlUpdateStatement mySqlUpdateStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlUpdateStatement mySqlUpdateStatement) {

    }

    @Override
    public boolean visit(MySqlSetTransactionStatement mySqlSetTransactionStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlSetTransactionStatement mySqlSetTransactionStatement) {

    }

    @Override
    public boolean visit(MySqlSetNamesStatement mySqlSetNamesStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlSetNamesStatement mySqlSetNamesStatement) {

    }

    @Override
    public boolean visit(MySqlSetCharSetStatement mySqlSetCharSetStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlSetCharSetStatement mySqlSetCharSetStatement) {

    }

    @Override
    public boolean visit(MySqlShowBinaryLogsStatement mySqlShowBinaryLogsStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowBinaryLogsStatement mySqlShowBinaryLogsStatement) {

    }

    @Override
    public boolean visit(MySqlShowMasterLogsStatement mySqlShowMasterLogsStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowMasterLogsStatement mySqlShowMasterLogsStatement) {

    }

    @Override
    public boolean visit(MySqlShowCharacterSetStatement mySqlShowCharacterSetStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowCharacterSetStatement mySqlShowCharacterSetStatement) {

    }

    @Override
    public boolean visit(MySqlShowCollationStatement mySqlShowCollationStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowCollationStatement mySqlShowCollationStatement) {

    }

    @Override
    public boolean visit(MySqlShowBinLogEventsStatement mySqlShowBinLogEventsStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowBinLogEventsStatement mySqlShowBinLogEventsStatement) {

    }

    @Override
    public boolean visit(MySqlShowContributorsStatement mySqlShowContributorsStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowContributorsStatement mySqlShowContributorsStatement) {

    }

    @Override
    public boolean visit(MySqlShowCreateDatabaseStatement mySqlShowCreateDatabaseStatement) {
        info(mySqlShowCreateDatabaseStatement.getDatabase());
        return false;
    }

    @Override
    public void endVisit(MySqlShowCreateDatabaseStatement mySqlShowCreateDatabaseStatement) {

    }

    @Override
    public boolean visit(MySqlShowCreateEventStatement mySqlShowCreateEventStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowCreateEventStatement mySqlShowCreateEventStatement) {

    }

    @Override
    public boolean visit(MySqlShowCreateFunctionStatement mySqlShowCreateFunctionStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowCreateFunctionStatement mySqlShowCreateFunctionStatement) {

    }

    @Override
    public boolean visit(MySqlShowCreateProcedureStatement mySqlShowCreateProcedureStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowCreateProcedureStatement mySqlShowCreateProcedureStatement) {

    }

    @Override
    public boolean visit(MySqlShowCreateTableStatement mySqlShowCreateTableStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowCreateTableStatement mySqlShowCreateTableStatement) {

    }

    @Override
    public boolean visit(MySqlShowCreateTriggerStatement mySqlShowCreateTriggerStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowCreateTriggerStatement mySqlShowCreateTriggerStatement) {

    }

    @Override
    public boolean visit(MySqlShowCreateViewStatement mySqlShowCreateViewStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowCreateViewStatement mySqlShowCreateViewStatement) {

    }

    @Override
    public boolean visit(MySqlShowEngineStatement mySqlShowEngineStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowEngineStatement mySqlShowEngineStatement) {

    }

    @Override
    public boolean visit(MySqlShowEnginesStatement mySqlShowEnginesStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowEnginesStatement mySqlShowEnginesStatement) {

    }

    @Override
    public boolean visit(MySqlShowErrorsStatement mySqlShowErrorsStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowErrorsStatement mySqlShowErrorsStatement) {

    }

    @Override
    public boolean visit(MySqlShowEventsStatement mySqlShowEventsStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowEventsStatement mySqlShowEventsStatement) {

    }

    @Override
    public boolean visit(MySqlShowFunctionCodeStatement mySqlShowFunctionCodeStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowFunctionCodeStatement mySqlShowFunctionCodeStatement) {

    }

    @Override
    public boolean visit(MySqlShowFunctionStatusStatement mySqlShowFunctionStatusStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowFunctionStatusStatement mySqlShowFunctionStatusStatement) {

    }

    @Override
    public boolean visit(MySqlShowGrantsStatement mySqlShowGrantsStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowGrantsStatement mySqlShowGrantsStatement) {

    }

    @Override
    public boolean visit(MySqlUserName mySqlUserName) {
        return false;
    }

    @Override
    public void endVisit(MySqlUserName mySqlUserName) {

    }

    @Override
    public boolean visit(MySqlShowIndexesStatement mySqlShowIndexesStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowIndexesStatement mySqlShowIndexesStatement) {

    }

    @Override
    public boolean visit(MySqlShowKeysStatement mySqlShowKeysStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowKeysStatement mySqlShowKeysStatement) {

    }

    @Override
    public boolean visit(MySqlShowMasterStatusStatement mySqlShowMasterStatusStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowMasterStatusStatement mySqlShowMasterStatusStatement) {

    }

    @Override
    public boolean visit(MySqlShowOpenTablesStatement mySqlShowOpenTablesStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowOpenTablesStatement mySqlShowOpenTablesStatement) {

    }

    @Override
    public boolean visit(MySqlShowPluginsStatement mySqlShowPluginsStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowPluginsStatement mySqlShowPluginsStatement) {

    }

    @Override
    public boolean visit(MySqlShowPrivilegesStatement mySqlShowPrivilegesStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowPrivilegesStatement mySqlShowPrivilegesStatement) {

    }

    @Override
    public boolean visit(MySqlShowProcedureCodeStatement mySqlShowProcedureCodeStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowProcedureCodeStatement mySqlShowProcedureCodeStatement) {

    }

    @Override
    public boolean visit(MySqlShowProcedureStatusStatement mySqlShowProcedureStatusStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowProcedureStatusStatement mySqlShowProcedureStatusStatement) {

    }

    @Override
    public boolean visit(MySqlShowProcessListStatement mySqlShowProcessListStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowProcessListStatement mySqlShowProcessListStatement) {

    }

    @Override
    public boolean visit(MySqlShowProfileStatement mySqlShowProfileStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowProfileStatement mySqlShowProfileStatement) {

    }

    @Override
    public boolean visit(MySqlShowProfilesStatement mySqlShowProfilesStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowProfilesStatement mySqlShowProfilesStatement) {

    }

    @Override
    public boolean visit(MySqlShowRelayLogEventsStatement mySqlShowRelayLogEventsStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowRelayLogEventsStatement mySqlShowRelayLogEventsStatement) {

    }

    @Override
    public boolean visit(MySqlShowSlaveHostsStatement mySqlShowSlaveHostsStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowSlaveHostsStatement mySqlShowSlaveHostsStatement) {

    }

    @Override
    public boolean visit(MySqlShowSlaveStatusStatement mySqlShowSlaveStatusStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowSlaveStatusStatement mySqlShowSlaveStatusStatement) {

    }

    @Override
    public boolean visit(MySqlShowTableStatusStatement mySqlShowTableStatusStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowTableStatusStatement mySqlShowTableStatusStatement) {

    }

    @Override
    public boolean visit(MySqlShowTriggersStatement mySqlShowTriggersStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowTriggersStatement mySqlShowTriggersStatement) {

    }

    @Override
    public boolean visit(MySqlShowVariantsStatement mySqlShowVariantsStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlShowVariantsStatement mySqlShowVariantsStatement) {

    }

    @Override
    public boolean visit(MySqlRenameTableStatement.Item item) {
        return false;
    }

    @Override
    public void endVisit(MySqlRenameTableStatement.Item item) {

    }

    @Override
    public boolean visit(MySqlRenameTableStatement mySqlRenameTableStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlRenameTableStatement mySqlRenameTableStatement) {

    }

    @Override
    public boolean visit(MySqlUnionQuery mySqlUnionQuery) {
        return false;
    }

    @Override
    public void endVisit(MySqlUnionQuery mySqlUnionQuery) {

    }

    @Override
    public boolean visit(MySqlUseIndexHint mySqlUseIndexHint) {
        return false;
    }

    @Override
    public void endVisit(MySqlUseIndexHint mySqlUseIndexHint) {

    }

    @Override
    public boolean visit(MySqlIgnoreIndexHint mySqlIgnoreIndexHint) {
        return false;
    }

    @Override
    public void endVisit(MySqlIgnoreIndexHint mySqlIgnoreIndexHint) {

    }

    @Override
    public boolean visit(MySqlLockTableStatement mySqlLockTableStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlLockTableStatement mySqlLockTableStatement) {

    }

    @Override
    public boolean visit(MySqlUnlockTablesStatement mySqlUnlockTablesStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlUnlockTablesStatement mySqlUnlockTablesStatement) {

    }

    @Override
    public boolean visit(MySqlForceIndexHint mySqlForceIndexHint) {
        return false;
    }

    @Override
    public void endVisit(MySqlForceIndexHint mySqlForceIndexHint) {

    }

    @Override
    public boolean visit(MySqlAlterTableChangeColumn mySqlAlterTableChangeColumn) {
        return false;
    }

    @Override
    public void endVisit(MySqlAlterTableChangeColumn mySqlAlterTableChangeColumn) {

    }

    @Override
    public boolean visit(MySqlAlterTableCharacter mySqlAlterTableCharacter) {
        return false;
    }

    @Override
    public void endVisit(MySqlAlterTableCharacter mySqlAlterTableCharacter) {

    }

    @Override
    public boolean visit(MySqlAlterTableOption mySqlAlterTableOption) {
        return false;
    }

    @Override
    public void endVisit(MySqlAlterTableOption mySqlAlterTableOption) {

    }

    @Override
    public boolean visit(MySqlCreateTableStatement mySqlCreateTableStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlCreateTableStatement mySqlCreateTableStatement) {
        Msqlcreatetablehander instance = Msqlcreatetablehander.getInstance();
        instance.setDbname(DBadapter.currentDB);
        instance.handerexe(mySqlCreateTableStatement);
    }

    @Override
    public boolean visit(MySqlHelpStatement mySqlHelpStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlHelpStatement mySqlHelpStatement) {

    }

    @Override
    public boolean visit(MySqlCharExpr mySqlCharExpr) {
        return false;
    }

    @Override
    public void endVisit(MySqlCharExpr mySqlCharExpr) {

    }

    @Override
    public boolean visit(MySqlAlterTableModifyColumn mySqlAlterTableModifyColumn) {
        return false;
    }

    @Override
    public void endVisit(MySqlAlterTableModifyColumn mySqlAlterTableModifyColumn) {

    }

    @Override
    public boolean visit(MySqlAlterTableDiscardTablespace mySqlAlterTableDiscardTablespace) {
        return false;
    }

    @Override
    public void endVisit(MySqlAlterTableDiscardTablespace mySqlAlterTableDiscardTablespace) {

    }

    @Override
    public boolean visit(MySqlAlterTableImportTablespace mySqlAlterTableImportTablespace) {
        return false;
    }

    @Override
    public void endVisit(MySqlAlterTableImportTablespace mySqlAlterTableImportTablespace) {

    }

    @Override
    public boolean visit(MySqlCreateTableStatement.TableSpaceOption tableSpaceOption) {
        return false;
    }

    @Override
    public void endVisit(MySqlCreateTableStatement.TableSpaceOption tableSpaceOption) {

    }

    @Override
    public boolean visit(MySqlAnalyzeStatement mySqlAnalyzeStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlAnalyzeStatement mySqlAnalyzeStatement) {

    }

    @Override
    public boolean visit(MySqlAlterUserStatement mySqlAlterUserStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlAlterUserStatement mySqlAlterUserStatement) {

    }

    @Override
    public boolean visit(MySqlOptimizeStatement mySqlOptimizeStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlOptimizeStatement mySqlOptimizeStatement) {

    }

    @Override
    public boolean visit(MySqlSetPasswordStatement mySqlSetPasswordStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlSetPasswordStatement mySqlSetPasswordStatement) {

    }

    @Override
    public boolean visit(MySqlHintStatement mySqlHintStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlHintStatement mySqlHintStatement) {

    }

    @Override
    public boolean visit(MySqlOrderingExpr mySqlOrderingExpr) {
        return false;
    }

    @Override
    public void endVisit(MySqlOrderingExpr mySqlOrderingExpr) {

    }

    @Override
    public boolean visit(MySqlWhileStatement mySqlWhileStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlWhileStatement mySqlWhileStatement) {

    }

    @Override
    public boolean visit(MySqlCaseStatement mySqlCaseStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlCaseStatement mySqlCaseStatement) {

    }

    @Override
    public boolean visit(MySqlDeclareStatement mySqlDeclareStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlDeclareStatement mySqlDeclareStatement) {

    }

    @Override
    public boolean visit(MySqlSelectIntoStatement mySqlSelectIntoStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlSelectIntoStatement mySqlSelectIntoStatement) {

    }

    @Override
    public boolean visit(MySqlCaseStatement.MySqlWhenStatement mySqlWhenStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlCaseStatement.MySqlWhenStatement mySqlWhenStatement) {

    }

    @Override
    public boolean visit(MySqlLeaveStatement mySqlLeaveStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlLeaveStatement mySqlLeaveStatement) {

    }

    @Override
    public boolean visit(MySqlIterateStatement mySqlIterateStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlIterateStatement mySqlIterateStatement) {

    }

    @Override
    public boolean visit(MySqlRepeatStatement mySqlRepeatStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlRepeatStatement mySqlRepeatStatement) {

    }

    @Override
    public boolean visit(MySqlCursorDeclareStatement mySqlCursorDeclareStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlCursorDeclareStatement mySqlCursorDeclareStatement) {

    }

    @Override
    public boolean visit(MySqlUpdateTableSource mySqlUpdateTableSource) {
        return false;
    }

    @Override
    public void endVisit(MySqlUpdateTableSource mySqlUpdateTableSource) {

    }

    @Override
    public boolean visit(MySqlAlterTableAlterColumn mySqlAlterTableAlterColumn) {
        return false;
    }

    @Override
    public void endVisit(MySqlAlterTableAlterColumn mySqlAlterTableAlterColumn) {

    }

    @Override
    public boolean visit(MySqlSubPartitionByKey mySqlSubPartitionByKey) {
        return false;
    }

    @Override
    public void endVisit(MySqlSubPartitionByKey mySqlSubPartitionByKey) {

    }

    @Override
    public boolean visit(MySqlSubPartitionByList mySqlSubPartitionByList) {
        return false;
    }

    @Override
    public void endVisit(MySqlSubPartitionByList mySqlSubPartitionByList) {

    }

    @Override
    public boolean visit(MySqlDeclareHandlerStatement mySqlDeclareHandlerStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlDeclareHandlerStatement mySqlDeclareHandlerStatement) {

    }

    @Override
    public boolean visit(MySqlDeclareConditionStatement mySqlDeclareConditionStatement) {
        return false;
    }

    @Override
    public void endVisit(MySqlDeclareConditionStatement mySqlDeclareConditionStatement) {

    }

    @Override
    public void endVisit(SQLAllColumnExpr sqlAllColumnExpr) {

    }

    @Override
    public void endVisit(SQLBetweenExpr sqlBetweenExpr) {

    }

    @Override
    public void endVisit(SQLBinaryOpExpr sqlBinaryOpExpr) {

    }

    @Override
    public void endVisit(SQLCaseExpr sqlCaseExpr) {

    }

    @Override
    public void endVisit(SQLCaseExpr.Item item) {

    }

    @Override
    public void endVisit(SQLCharExpr sqlCharExpr) {

    }

    @Override
    public void endVisit(SQLIdentifierExpr sqlIdentifierExpr) {

    }

    @Override
    public void endVisit(SQLInListExpr sqlInListExpr) {

    }

    @Override
    public void endVisit(SQLIntegerExpr sqlIntegerExpr) {

    }

    @Override
    public void endVisit(SQLExistsExpr sqlExistsExpr) {

    }

    @Override
    public void endVisit(SQLNCharExpr sqlnCharExpr) {

    }

    @Override
    public void endVisit(SQLNotExpr sqlNotExpr) {

    }

    @Override
    public void endVisit(SQLNullExpr sqlNullExpr) {

    }

    @Override
    public void endVisit(SQLNumberExpr sqlNumberExpr) {

    }

    @Override
    public void endVisit(SQLPropertyExpr sqlPropertyExpr) {

    }

    @Override
    public void endVisit(SQLSelectGroupByClause sqlSelectGroupByClause) {

    }

    @Override
    public void endVisit(SQLSelectItem sqlSelectItem) {

    }

    @Override
    public void endVisit(SQLSelectStatement sqlSelectStatement) {

    }

    @Override
    public void postVisit(SQLObject sqlObject) {

    }

    @Override
    public void preVisit(SQLObject sqlObject) {

    }

    @Override
    public boolean visit(SQLAllColumnExpr sqlAllColumnExpr) {
        return false;
    }

    @Override
    public boolean visit(SQLBetweenExpr sqlBetweenExpr) {
        return false;
    }

    @Override
    public boolean visit(SQLBinaryOpExpr sqlBinaryOpExpr) {
        return false;
    }

    @Override
    public boolean visit(SQLCaseExpr sqlCaseExpr) {
        return false;
    }

    @Override
    public boolean visit(SQLCaseExpr.Item item) {
        return false;
    }

    @Override
    public boolean visit(SQLCastExpr sqlCastExpr) {
        return false;
    }

    @Override
    public boolean visit(SQLCharExpr sqlCharExpr) {
        return false;
    }

    @Override
    public boolean visit(SQLExistsExpr sqlExistsExpr) {
        return false;
    }

    @Override
    public boolean visit(SQLIdentifierExpr sqlIdentifierExpr) {
        return false;
    }

    @Override
    public boolean visit(SQLInListExpr sqlInListExpr) {
        return false;
    }

    @Override
    public boolean visit(SQLIntegerExpr sqlIntegerExpr) {
        return false;
    }

    @Override
    public boolean visit(SQLNCharExpr sqlnCharExpr) {
        return false;
    }

    @Override
    public boolean visit(SQLNotExpr sqlNotExpr) {
        return false;
    }

    @Override
    public boolean visit(SQLNullExpr sqlNullExpr) {
        return false;
    }

    @Override
    public boolean visit(SQLNumberExpr sqlNumberExpr) {
        return false;
    }

    @Override
    public boolean visit(SQLPropertyExpr sqlPropertyExpr) {
        return false;
    }

    @Override
    public boolean visit(SQLSelectGroupByClause sqlSelectGroupByClause) {
        return false;
    }

    @Override
    public boolean visit(SQLSelectItem sqlSelectItem) {
        return false;
    }

    @Override
    public void endVisit(SQLCastExpr sqlCastExpr) {

    }

    @Override
    public boolean visit(SQLSelectStatement sqlSelectStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLAggregateExpr sqlAggregateExpr) {

    }

    @Override
    public boolean visit(SQLAggregateExpr sqlAggregateExpr) {
        return false;
    }

    @Override
    public boolean visit(SQLVariantRefExpr sqlVariantRefExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLVariantRefExpr sqlVariantRefExpr) {

    }

    @Override
    public boolean visit(SQLQueryExpr sqlQueryExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLQueryExpr sqlQueryExpr) {

    }

    @Override
    public boolean visit(SQLUnaryExpr sqlUnaryExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLUnaryExpr sqlUnaryExpr) {

    }

    @Override
    public boolean visit(SQLHexExpr sqlHexExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLHexExpr sqlHexExpr) {

    }

    @Override
    public boolean visit(SQLSelect sqlSelect) {
        return false;
    }

    @Override
    public void endVisit(SQLSelect sqlSelect) {

    }

    @Override
    public boolean visit(SQLSelectQueryBlock sqlSelectQueryBlock) {
        return false;
    }

    @Override
    public void endVisit(SQLSelectQueryBlock sqlSelectQueryBlock) {

    }

    @Override
    public boolean visit(SQLExprTableSource sqlExprTableSource) {
        return false;
    }

    @Override
    public void endVisit(SQLExprTableSource sqlExprTableSource) {

    }

    @Override
    public boolean visit(SQLOrderBy sqlOrderBy) {
        return false;
    }

    @Override
    public void endVisit(SQLOrderBy sqlOrderBy) {

    }

    @Override
    public boolean visit(SQLSelectOrderByItem sqlSelectOrderByItem) {
        return false;
    }

    @Override
    public void endVisit(SQLSelectOrderByItem sqlSelectOrderByItem) {

    }

    @Override
    public boolean visit(SQLDropTableStatement sqlDropTableStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLDropTableStatement sqlDropTableStatement) {

    }

    @Override
    public boolean visit(SQLCreateTableStatement sqlCreateTableStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLCreateTableStatement sqlCreateTableStatement) {

    }

    @Override
    public boolean visit(SQLColumnDefinition sqlColumnDefinition) {
        return false;
    }

    @Override
    public void endVisit(SQLColumnDefinition sqlColumnDefinition) {

    }

    @Override
    public boolean visit(SQLColumnDefinition.Identity identity) {
        return false;
    }

    @Override
    public void endVisit(SQLColumnDefinition.Identity identity) {

    }

    @Override
    public boolean visit(SQLDataType sqlDataType) {
        return false;
    }

    @Override
    public void endVisit(SQLDataType sqlDataType) {

    }

    @Override
    public boolean visit(SQLCharacterDataType sqlCharacterDataType) {
        return false;
    }

    @Override
    public void endVisit(SQLCharacterDataType sqlCharacterDataType) {

    }

    @Override
    public boolean visit(SQLDeleteStatement sqlDeleteStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLDeleteStatement sqlDeleteStatement) {

    }

    @Override
    public boolean visit(SQLCurrentOfCursorExpr sqlCurrentOfCursorExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLCurrentOfCursorExpr sqlCurrentOfCursorExpr) {

    }

    @Override
    public boolean visit(SQLInsertStatement sqlInsertStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLInsertStatement sqlInsertStatement) {

    }

    @Override
    public boolean visit(SQLInsertStatement.ValuesClause valuesClause) {
        return false;
    }

    @Override
    public void endVisit(SQLInsertStatement.ValuesClause valuesClause) {

    }

    @Override
    public boolean visit(SQLUpdateSetItem sqlUpdateSetItem) {
        return false;
    }

    @Override
    public void endVisit(SQLUpdateSetItem sqlUpdateSetItem) {

    }

    @Override
    public boolean visit(SQLUpdateStatement sqlUpdateStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLUpdateStatement sqlUpdateStatement) {

    }

    @Override
    public boolean visit(SQLCreateViewStatement sqlCreateViewStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLCreateViewStatement sqlCreateViewStatement) {

    }

    @Override
    public boolean visit(SQLCreateViewStatement.Column column) {
        return false;
    }

    @Override
    public void endVisit(SQLCreateViewStatement.Column column) {

    }

    @Override
    public boolean visit(SQLNotNullConstraint sqlNotNullConstraint) {
        return false;
    }

    @Override
    public void endVisit(SQLNotNullConstraint sqlNotNullConstraint) {

    }

    @Override
    public void endVisit(SQLMethodInvokeExpr sqlMethodInvokeExpr) {

    }

    @Override
    public boolean visit(SQLMethodInvokeExpr sqlMethodInvokeExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLUnionQuery sqlUnionQuery) {

    }

    @Override
    public boolean visit(SQLUnionQuery sqlUnionQuery) {
        return false;
    }

    @Override
    public void endVisit(SQLSetStatement sqlSetStatement) {

    }

    @Override
    public boolean visit(SQLSetStatement sqlSetStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLAssignItem sqlAssignItem) {

    }

    @Override
    public boolean visit(SQLAssignItem sqlAssignItem) {
        return false;
    }

    @Override
    public void endVisit(SQLCallStatement sqlCallStatement) {

    }

    @Override
    public boolean visit(SQLCallStatement sqlCallStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLJoinTableSource sqlJoinTableSource) {

    }

    @Override
    public boolean visit(SQLJoinTableSource sqlJoinTableSource) {
        return false;
    }

    @Override
    public void endVisit(SQLSomeExpr sqlSomeExpr) {

    }

    @Override
    public boolean visit(SQLSomeExpr sqlSomeExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLAnyExpr sqlAnyExpr) {

    }

    @Override
    public boolean visit(SQLAnyExpr sqlAnyExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLAllExpr sqlAllExpr) {

    }

    @Override
    public boolean visit(SQLAllExpr sqlAllExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLInSubQueryExpr sqlInSubQueryExpr) {

    }

    @Override
    public boolean visit(SQLInSubQueryExpr sqlInSubQueryExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLListExpr sqlListExpr) {

    }

    @Override
    public boolean visit(SQLListExpr sqlListExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLSubqueryTableSource sqlSubqueryTableSource) {

    }

    @Override
    public boolean visit(SQLSubqueryTableSource sqlSubqueryTableSource) {
        return false;
    }

    @Override
    public void endVisit(SQLTruncateStatement sqlTruncateStatement) {

    }

    @Override
    public boolean visit(SQLTruncateStatement sqlTruncateStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLDefaultExpr sqlDefaultExpr) {

    }

    @Override
    public boolean visit(SQLDefaultExpr sqlDefaultExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLCommentStatement sqlCommentStatement) {

    }

    @Override
    public boolean visit(SQLCommentStatement sqlCommentStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLUseStatement sqlUseStatement) {

    }

    @Override
    public boolean visit(SQLUseStatement sqlUseStatement) {
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAddColumn sqlAlterTableAddColumn) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableAddColumn sqlAlterTableAddColumn) {

    }

    @Override
    public boolean visit(SQLAlterTableDropColumnItem sqlAlterTableDropColumnItem) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableDropColumnItem sqlAlterTableDropColumnItem) {

    }

    @Override
    public boolean visit(SQLAlterTableDropIndex sqlAlterTableDropIndex) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableDropIndex sqlAlterTableDropIndex) {

    }

    @Override
    public boolean visit(SQLDropIndexStatement sqlDropIndexStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLDropIndexStatement sqlDropIndexStatement) {

    }

    @Override
    public boolean visit(SQLDropViewStatement sqlDropViewStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLDropViewStatement sqlDropViewStatement) {

    }

    @Override
    public boolean visit(SQLSavePointStatement sqlSavePointStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLSavePointStatement sqlSavePointStatement) {

    }

    @Override
    public boolean visit(SQLRollbackStatement sqlRollbackStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLRollbackStatement sqlRollbackStatement) {

    }

    @Override
    public boolean visit(SQLReleaseSavePointStatement sqlReleaseSavePointStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLReleaseSavePointStatement sqlReleaseSavePointStatement) {

    }

    @Override
    public void endVisit(SQLCommentHint sqlCommentHint) {

    }

    @Override
    public boolean visit(SQLCommentHint sqlCommentHint) {
        return false;
    }

    @Override
    public void endVisit(SQLCreateDatabaseStatement sqlCreateDatabaseStatement) {
        MCreateDatabasehander.getInstance().handerexe(sqlCreateDatabaseStatement);
    }

    @Override
    public boolean visit(SQLCreateDatabaseStatement sqlCreateDatabaseStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLOver sqlOver) {

    }

    @Override
    public boolean visit(SQLOver sqlOver) {
        return false;
    }

    @Override
    public void endVisit(SQLKeep sqlKeep) {

    }

    @Override
    public boolean visit(SQLKeep sqlKeep) {
        return false;
    }

    @Override
    public void endVisit(SQLColumnPrimaryKey sqlColumnPrimaryKey) {

    }

    @Override
    public boolean visit(SQLColumnPrimaryKey sqlColumnPrimaryKey) {
        return false;
    }

    @Override
    public boolean visit(SQLColumnUniqueKey sqlColumnUniqueKey) {
        return false;
    }

    @Override
    public void endVisit(SQLColumnUniqueKey sqlColumnUniqueKey) {

    }

    @Override
    public void endVisit(SQLWithSubqueryClause sqlWithSubqueryClause) {

    }

    @Override
    public boolean visit(SQLWithSubqueryClause sqlWithSubqueryClause) {
        return false;
    }

    @Override
    public void endVisit(SQLWithSubqueryClause.Entry entry) {

    }

    @Override
    public boolean visit(SQLWithSubqueryClause.Entry entry) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableAlterColumn sqlAlterTableAlterColumn) {

    }

    @Override
    public boolean visit(SQLAlterTableAlterColumn sqlAlterTableAlterColumn) {
        return false;
    }

    @Override
    public boolean visit(SQLCheck sqlCheck) {
        return false;
    }

    @Override
    public void endVisit(SQLCheck sqlCheck) {

    }

    @Override
    public boolean visit(SQLAlterTableDropForeignKey sqlAlterTableDropForeignKey) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableDropForeignKey sqlAlterTableDropForeignKey) {

    }

    @Override
    public boolean visit(SQLAlterTableDropPrimaryKey sqlAlterTableDropPrimaryKey) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableDropPrimaryKey sqlAlterTableDropPrimaryKey) {

    }

    @Override
    public boolean visit(SQLAlterTableDisableKeys sqlAlterTableDisableKeys) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableDisableKeys sqlAlterTableDisableKeys) {

    }

    @Override
    public boolean visit(SQLAlterTableEnableKeys sqlAlterTableEnableKeys) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableEnableKeys sqlAlterTableEnableKeys) {

    }

    @Override
    public boolean visit(SQLAlterTableStatement sqlAlterTableStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableStatement sqlAlterTableStatement) {

    }

    @Override
    public boolean visit(SQLAlterTableDisableConstraint sqlAlterTableDisableConstraint) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableDisableConstraint sqlAlterTableDisableConstraint) {

    }

    @Override
    public boolean visit(SQLAlterTableEnableConstraint sqlAlterTableEnableConstraint) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableEnableConstraint sqlAlterTableEnableConstraint) {

    }

    @Override
    public boolean visit(SQLColumnCheck sqlColumnCheck) {
        return false;
    }

    @Override
    public void endVisit(SQLColumnCheck sqlColumnCheck) {

    }

    @Override
    public boolean visit(SQLExprHint sqlExprHint) {
        return false;
    }

    @Override
    public void endVisit(SQLExprHint sqlExprHint) {

    }

    @Override
    public boolean visit(SQLAlterTableDropConstraint sqlAlterTableDropConstraint) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableDropConstraint sqlAlterTableDropConstraint) {

    }

    @Override
    public boolean visit(SQLUnique sqlUnique) {
        return false;
    }

    @Override
    public void endVisit(SQLUnique sqlUnique) {

    }

    @Override
    public boolean visit(SQLPrimaryKeyImpl sqlPrimaryKey) {
        return false;
    }

    @Override
    public void endVisit(SQLPrimaryKeyImpl sqlPrimaryKey) {

    }

    @Override
    public boolean visit(SQLCreateIndexStatement sqlCreateIndexStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLCreateIndexStatement sqlCreateIndexStatement) {

    }

    @Override
    public boolean visit(SQLAlterTableRenameColumn sqlAlterTableRenameColumn) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableRenameColumn sqlAlterTableRenameColumn) {

    }

    @Override
    public boolean visit(SQLColumnReference sqlColumnReference) {
        return false;
    }

    @Override
    public void endVisit(SQLColumnReference sqlColumnReference) {

    }

    @Override
    public boolean visit(SQLForeignKeyImpl sqlForeignKey) {
        return false;
    }

    @Override
    public void endVisit(SQLForeignKeyImpl sqlForeignKey) {

    }

    @Override
    public boolean visit(SQLDropSequenceStatement sqlDropSequenceStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLDropSequenceStatement sqlDropSequenceStatement) {

    }

    @Override
    public boolean visit(SQLDropTriggerStatement sqlDropTriggerStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLDropTriggerStatement sqlDropTriggerStatement) {

    }

    @Override
    public void endVisit(SQLDropUserStatement sqlDropUserStatement) {

    }

    @Override
    public boolean visit(SQLDropUserStatement sqlDropUserStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLExplainStatement sqlExplainStatement) {

    }

    @Override
    public boolean visit(SQLExplainStatement sqlExplainStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLGrantStatement sqlGrantStatement) {

    }

    @Override
    public boolean visit(SQLGrantStatement sqlGrantStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLDropDatabaseStatement sqlDropDatabaseStatement) {

    }

    @Override
    public boolean visit(SQLDropDatabaseStatement sqlDropDatabaseStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableAddIndex sqlAlterTableAddIndex) {

    }

    @Override
    public boolean visit(SQLAlterTableAddIndex sqlAlterTableAddIndex) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableAddConstraint sqlAlterTableAddConstraint) {

    }

    @Override
    public boolean visit(SQLAlterTableAddConstraint sqlAlterTableAddConstraint) {
        return false;
    }

    @Override
    public void endVisit(SQLCreateTriggerStatement sqlCreateTriggerStatement) {

    }

    @Override
    public boolean visit(SQLCreateTriggerStatement sqlCreateTriggerStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLDropFunctionStatement sqlDropFunctionStatement) {

    }

    @Override
    public boolean visit(SQLDropFunctionStatement sqlDropFunctionStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLDropTableSpaceStatement sqlDropTableSpaceStatement) {

    }

    @Override
    public boolean visit(SQLDropTableSpaceStatement sqlDropTableSpaceStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLDropProcedureStatement sqlDropProcedureStatement) {

    }

    @Override
    public boolean visit(SQLDropProcedureStatement sqlDropProcedureStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLBooleanExpr sqlBooleanExpr) {

    }

    @Override
    public boolean visit(SQLBooleanExpr sqlBooleanExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLUnionQueryTableSource sqlUnionQueryTableSource) {

    }

    @Override
    public boolean visit(SQLUnionQueryTableSource sqlUnionQueryTableSource) {
        return false;
    }

    @Override
    public void endVisit(SQLTimestampExpr sqlTimestampExpr) {

    }

    @Override
    public boolean visit(SQLTimestampExpr sqlTimestampExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLRevokeStatement sqlRevokeStatement) {

    }

    @Override
    public boolean visit(SQLRevokeStatement sqlRevokeStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLBinaryExpr sqlBinaryExpr) {

    }

    @Override
    public boolean visit(SQLBinaryExpr sqlBinaryExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableRename sqlAlterTableRename) {

    }

    @Override
    public boolean visit(SQLAlterTableRename sqlAlterTableRename) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterViewRenameStatement sqlAlterViewRenameStatement) {

    }

    @Override
    public boolean visit(SQLAlterViewRenameStatement sqlAlterViewRenameStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLShowTablesStatement sqlShowTablesStatement) {

    }

    @Override
    public boolean visit(SQLShowTablesStatement sqlShowTablesStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableAddPartition sqlAlterTableAddPartition) {

    }

    @Override
    public boolean visit(SQLAlterTableAddPartition sqlAlterTableAddPartition) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableDropPartition sqlAlterTableDropPartition) {

    }

    @Override
    public boolean visit(SQLAlterTableDropPartition sqlAlterTableDropPartition) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableRenamePartition sqlAlterTableRenamePartition) {

    }

    @Override
    public boolean visit(SQLAlterTableRenamePartition sqlAlterTableRenamePartition) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableSetComment sqlAlterTableSetComment) {

    }

    @Override
    public boolean visit(SQLAlterTableSetComment sqlAlterTableSetComment) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableSetLifecycle sqlAlterTableSetLifecycle) {

    }

    @Override
    public boolean visit(SQLAlterTableSetLifecycle sqlAlterTableSetLifecycle) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableEnableLifecycle sqlAlterTableEnableLifecycle) {

    }

    @Override
    public boolean visit(SQLAlterTableEnableLifecycle sqlAlterTableEnableLifecycle) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableDisableLifecycle sqlAlterTableDisableLifecycle) {

    }

    @Override
    public boolean visit(SQLAlterTableDisableLifecycle sqlAlterTableDisableLifecycle) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableTouch sqlAlterTableTouch) {

    }

    @Override
    public boolean visit(SQLAlterTableTouch sqlAlterTableTouch) {
        return false;
    }

    @Override
    public void endVisit(SQLArrayExpr sqlArrayExpr) {

    }

    @Override
    public boolean visit(SQLArrayExpr sqlArrayExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLOpenStatement sqlOpenStatement) {

    }

    @Override
    public boolean visit(SQLOpenStatement sqlOpenStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLFetchStatement sqlFetchStatement) {

    }

    @Override
    public boolean visit(SQLFetchStatement sqlFetchStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLCloseStatement sqlCloseStatement) {

    }

    @Override
    public boolean visit(SQLCloseStatement sqlCloseStatement) {
        return false;
    }

    @Override
    public boolean visit(SQLGroupingSetExpr sqlGroupingSetExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLGroupingSetExpr sqlGroupingSetExpr) {

    }

    @Override
    public boolean visit(SQLIfStatement sqlIfStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLIfStatement sqlIfStatement) {

    }

    @Override
    public boolean visit(SQLIfStatement.ElseIf elseIf) {
        return false;
    }

    @Override
    public void endVisit(SQLIfStatement.ElseIf elseIf) {

    }

    @Override
    public boolean visit(SQLIfStatement.Else anElse) {
        return false;
    }

    @Override
    public void endVisit(SQLIfStatement.Else anElse) {

    }

    @Override
    public boolean visit(SQLLoopStatement sqlLoopStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLLoopStatement sqlLoopStatement) {

    }

    @Override
    public boolean visit(SQLParameter sqlParameter) {
        return false;
    }

    @Override
    public void endVisit(SQLParameter sqlParameter) {

    }

    @Override
    public boolean visit(SQLCreateProcedureStatement sqlCreateProcedureStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLCreateProcedureStatement sqlCreateProcedureStatement) {

    }

    @Override
    public boolean visit(SQLBlockStatement sqlBlockStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLBlockStatement sqlBlockStatement) {

    }

    @Override
    public boolean visit(SQLAlterTableDropKey sqlAlterTableDropKey) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableDropKey sqlAlterTableDropKey) {

    }

    @Override
    public boolean visit(SQLDeclareItem sqlDeclareItem) {
        return false;
    }

    @Override
    public void endVisit(SQLDeclareItem sqlDeclareItem) {

    }

    @Override
    public boolean visit(SQLPartitionValue sqlPartitionValue) {
        return false;
    }

    @Override
    public void endVisit(SQLPartitionValue sqlPartitionValue) {

    }

    @Override
    public boolean visit(SQLPartition sqlPartition) {
        return false;
    }

    @Override
    public void endVisit(SQLPartition sqlPartition) {

    }

    @Override
    public boolean visit(SQLPartitionByRange sqlPartitionByRange) {
        return false;
    }

    @Override
    public void endVisit(SQLPartitionByRange sqlPartitionByRange) {

    }

    @Override
    public boolean visit(SQLPartitionByHash sqlPartitionByHash) {
        return false;
    }

    @Override
    public void endVisit(SQLPartitionByHash sqlPartitionByHash) {

    }

    @Override
    public boolean visit(SQLPartitionByList sqlPartitionByList) {
        return false;
    }

    @Override
    public void endVisit(SQLPartitionByList sqlPartitionByList) {

    }

    @Override
    public boolean visit(SQLSubPartition sqlSubPartition) {
        return false;
    }

    @Override
    public void endVisit(SQLSubPartition sqlSubPartition) {

    }

    @Override
    public boolean visit(SQLSubPartitionByHash sqlSubPartitionByHash) {
        return false;
    }

    @Override
    public void endVisit(SQLSubPartitionByHash sqlSubPartitionByHash) {

    }

    @Override
    public boolean visit(SQLSubPartitionByList sqlSubPartitionByList) {
        return false;
    }

    @Override
    public void endVisit(SQLSubPartitionByList sqlSubPartitionByList) {

    }

    @Override
    public boolean visit(SQLAlterDatabaseStatement sqlAlterDatabaseStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterDatabaseStatement sqlAlterDatabaseStatement) {

    }

    @Override
    public boolean visit(SQLAlterTableConvertCharSet sqlAlterTableConvertCharSet) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableConvertCharSet sqlAlterTableConvertCharSet) {

    }

    @Override
    public boolean visit(SQLAlterTableReOrganizePartition sqlAlterTableReOrganizePartition) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableReOrganizePartition sqlAlterTableReOrganizePartition) {

    }

    @Override
    public boolean visit(SQLAlterTableCoalescePartition sqlAlterTableCoalescePartition) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableCoalescePartition sqlAlterTableCoalescePartition) {

    }

    @Override
    public boolean visit(SQLAlterTableTruncatePartition sqlAlterTableTruncatePartition) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableTruncatePartition sqlAlterTableTruncatePartition) {

    }

    @Override
    public boolean visit(SQLAlterTableDiscardPartition sqlAlterTableDiscardPartition) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableDiscardPartition sqlAlterTableDiscardPartition) {

    }

    @Override
    public boolean visit(SQLAlterTableImportPartition sqlAlterTableImportPartition) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableImportPartition sqlAlterTableImportPartition) {

    }

    @Override
    public boolean visit(SQLAlterTableAnalyzePartition sqlAlterTableAnalyzePartition) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableAnalyzePartition sqlAlterTableAnalyzePartition) {

    }

    @Override
    public boolean visit(SQLAlterTableCheckPartition sqlAlterTableCheckPartition) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableCheckPartition sqlAlterTableCheckPartition) {

    }

    @Override
    public boolean visit(SQLAlterTableOptimizePartition sqlAlterTableOptimizePartition) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableOptimizePartition sqlAlterTableOptimizePartition) {

    }

    @Override
    public boolean visit(SQLAlterTableRebuildPartition sqlAlterTableRebuildPartition) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableRebuildPartition sqlAlterTableRebuildPartition) {

    }

    @Override
    public boolean visit(SQLAlterTableRepairPartition sqlAlterTableRepairPartition) {
        return false;
    }

    @Override
    public void endVisit(SQLAlterTableRepairPartition sqlAlterTableRepairPartition) {

    }

    @Override
    public boolean visit(SQLSequenceExpr sqlSequenceExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLSequenceExpr sqlSequenceExpr) {

    }

    @Override
    public boolean visit(SQLMergeStatement sqlMergeStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLMergeStatement sqlMergeStatement) {

    }

    @Override
    public boolean visit(SQLMergeStatement.MergeUpdateClause mergeUpdateClause) {
        return false;
    }

    @Override
    public void endVisit(SQLMergeStatement.MergeUpdateClause mergeUpdateClause) {

    }

    @Override
    public boolean visit(SQLMergeStatement.MergeInsertClause mergeInsertClause) {
        return false;
    }

    @Override
    public void endVisit(SQLMergeStatement.MergeInsertClause mergeInsertClause) {

    }

    @Override
    public boolean visit(SQLErrorLoggingClause sqlErrorLoggingClause) {
        return false;
    }

    @Override
    public void endVisit(SQLErrorLoggingClause sqlErrorLoggingClause) {

    }

    @Override
    public boolean visit(SQLNullConstraint sqlNullConstraint) {
        return false;
    }

    @Override
    public void endVisit(SQLNullConstraint sqlNullConstraint) {

    }

    @Override
    public boolean visit(SQLCreateSequenceStatement sqlCreateSequenceStatement) {
        return false;
    }

    @Override
    public void endVisit(SQLCreateSequenceStatement sqlCreateSequenceStatement) {

    }

    @Override
    public boolean visit(SQLDateExpr sqlDateExpr) {
        return false;
    }

    @Override
    public void endVisit(SQLDateExpr sqlDateExpr) {

    }
}
