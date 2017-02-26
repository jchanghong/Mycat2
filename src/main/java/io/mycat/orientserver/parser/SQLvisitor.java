package io.mycat.orientserver.parser;

import com.alibaba.druid.sql.ast.*;
import com.alibaba.druid.sql.ast.expr.*;
import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.ast.*;
import com.alibaba.druid.sql.dialect.mysql.ast.clause.*;
import com.alibaba.druid.sql.dialect.mysql.ast.expr.*;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlASTVisitorAdapter;
import io.mycat.orientserver.OConnection;
import io.mycat.orientserver.handler.DefaultHander;
import io.mycat.orientserver.handler.adminstatement.ShowDatabase;
import io.mycat.orientserver.handler.datadefine.CreateDababaseHander;

public class SQLvisitor extends MySqlASTVisitorAdapter{
    OConnection connection;

    public SQLvisitor(OConnection oConnection) {
        super();
        connection = oConnection;
    }

    @Override
    public boolean visit(MySqlSelectQueryBlock.Limit x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlSelectQueryBlock.Limit x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlTableIndex x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlTableIndex x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlKey x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlKey x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlPrimaryKey x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlPrimaryKey x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(MySqlIntervalExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlIntervalExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlExtractExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlExtractExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlMatchAgainstExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlMatchAgainstExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlPrepareStatement x) {
        super.endVisit(x);
        DefaultHander.handle(x,connection);
    }

    @Override
    public boolean visit(MySqlPrepareStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlExecuteStatement x) {
        super.endVisit(x);
        DefaultHander.handle(x,connection);
    }

    @Override
    public boolean visit(MySqlExecuteStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MysqlDeallocatePrepareStatement x) {
        super.endVisit(x);
        DefaultHander.handle(x,connection);
    }

    @Override
    public boolean visit(MysqlDeallocatePrepareStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlDeleteStatement x) {
        super.endVisit(x);
        DefaultHander.handle(x,connection);
    }

    @Override
    public boolean visit(MySqlDeleteStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlInsertStatement x) {
        DefaultHander.handle(x,connection);
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlInsertStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlLoadDataInFileStatement x) {
        DefaultHander.handle(x,connection);
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlLoadDataInFileStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlLoadXmlStatement x) {
        DefaultHander.handle(x,connection);
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlLoadXmlStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlReplaceStatement x) {
        DefaultHander.handle(x,connection);
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlReplaceStatement x) {
        DefaultHander.handle(x,connection);
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlStartTransactionStatement x) {
        DefaultHander.handle(x,connection);
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlStartTransactionStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlCommitStatement x) {
        DefaultHander.handle(x,connection);
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlCommitStatement x) {
        DefaultHander.handle(x,connection);
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlRollbackStatement x) {
        DefaultHander.handle(x,connection);
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlRollbackStatement x) {
        return super.visit(x);
    }


    @Override
    public void endVisit(MySqlShowColumnsStatement x) {
        DefaultHander.handle(x,connection);
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowColumnsStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowDatabasesStatement x) {
        DefaultHander.handle(x,connection);
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowDatabasesStatement x) {
        ShowDatabase.handle(x, connection);
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowWarningsStatement x) {
        DefaultHander.handle(x,connection);
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowWarningsStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowStatusStatement x) {
        super.endVisit(x);  DefaultHander.handle(x,connection);
    }

    @Override
    public boolean visit(MySqlShowStatusStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(CobarShowStatus x) {
        super.endVisit(x);  DefaultHander.handle(x,connection);
    }

    @Override
    public boolean visit(CobarShowStatus x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlKillStatement x) {
        super.endVisit(x);  DefaultHander.handle(x,connection);
    }

    @Override
    public boolean visit(MySqlKillStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlBinlogStatement x) {
        super.endVisit(x);  DefaultHander.handle(x,connection);
    }

    @Override
    public boolean visit(MySqlBinlogStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlResetStatement x) {
        super.endVisit(x);  DefaultHander.handle(x,connection);
    }

    @Override
    public boolean visit(MySqlResetStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlCreateUserStatement x) {
        super.endVisit(x);  DefaultHander.handle(x,connection);
    }

    @Override
    public boolean visit(MySqlCreateUserStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlCreateUserStatement.UserSpecification x) {
        super.endVisit(x);  DefaultHander.handle(x,connection);
    }

    @Override
    public boolean visit(MySqlCreateUserStatement.UserSpecification x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlPartitionByKey x) {
        super.endVisit(x);  DefaultHander.handle(x,connection);
    }

    @Override
    public boolean visit(MySqlPartitionByKey x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(MySqlSelectQueryBlock x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlSelectQueryBlock x) {
        super.endVisit(x);  DefaultHander.handle(x,connection);
    }

    @Override
    public boolean visit(MySqlOutFileExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlOutFileExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlDescribeStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlDescribeStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlUpdateStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlUpdateStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlSetTransactionStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlSetTransactionStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlSetNamesStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlSetNamesStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlSetCharSetStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlSetCharSetStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowAuthorsStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowAuthorsStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowBinaryLogsStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowBinaryLogsStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowMasterLogsStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowMasterLogsStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowCollationStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowCollationStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowBinLogEventsStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowBinLogEventsStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowCharacterSetStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowCharacterSetStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowContributorsStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowContributorsStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowCreateDatabaseStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowCreateDatabaseStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowCreateEventStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowCreateEventStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowCreateFunctionStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowCreateFunctionStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowCreateProcedureStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowCreateProcedureStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowCreateTableStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowCreateTableStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowCreateTriggerStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowCreateTriggerStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowCreateViewStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowCreateViewStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowEngineStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowEngineStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowEnginesStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowEnginesStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowErrorsStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowErrorsStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowEventsStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowEventsStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowFunctionCodeStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowFunctionCodeStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowFunctionStatusStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowFunctionStatusStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowGrantsStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowGrantsStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlUserName x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlUserName x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowIndexesStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowIndexesStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowKeysStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowKeysStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowMasterStatusStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowMasterStatusStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowOpenTablesStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowOpenTablesStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowPluginsStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowPluginsStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowPrivilegesStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowPrivilegesStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowProcedureCodeStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowProcedureCodeStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowProcedureStatusStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowProcedureStatusStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowProcessListStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowProcessListStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowProfileStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowProfileStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowProfilesStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowProfilesStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowRelayLogEventsStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowRelayLogEventsStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowSlaveHostsStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowSlaveHostsStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowSlaveStatusStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowSlaveStatusStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowTableStatusStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowTableStatusStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowTriggersStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowTriggersStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlShowVariantsStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlShowVariantsStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlRenameTableStatement.Item x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlRenameTableStatement.Item x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlRenameTableStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlRenameTableStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlUnionQuery x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlUnionQuery x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlUseIndexHint x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlUseIndexHint x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlIgnoreIndexHint x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlIgnoreIndexHint x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlLockTableStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlLockTableStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlUnlockTablesStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlUnlockTablesStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlForceIndexHint x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlForceIndexHint x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlAlterTableChangeColumn x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlAlterTableChangeColumn x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlAlterTableCharacter x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlAlterTableCharacter x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlAlterTableOption x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlAlterTableOption x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlCreateTableStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlCreateTableStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlHelpStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlHelpStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlCharExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlCharExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlUnique x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlUnique x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MysqlForeignKey x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MysqlForeignKey x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlAlterTableModifyColumn x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlAlterTableModifyColumn x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlAlterTableDiscardTablespace x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlAlterTableDiscardTablespace x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlAlterTableImportTablespace x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlAlterTableImportTablespace x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlCreateTableStatement.TableSpaceOption x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlCreateTableStatement.TableSpaceOption x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlAnalyzeStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlAnalyzeStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlAlterUserStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlAlterUserStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlOptimizeStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlOptimizeStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlSetPasswordStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlSetPasswordStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlHintStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlHintStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlOrderingExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlOrderingExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlWhileStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlWhileStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlCaseStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlCaseStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlDeclareStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlDeclareStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlSelectIntoStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlSelectIntoStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlCaseStatement.MySqlWhenStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlCaseStatement.MySqlWhenStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlLeaveStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlLeaveStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlIterateStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlIterateStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlRepeatStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlRepeatStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlCursorDeclareStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlCursorDeclareStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlUpdateTableSource x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlUpdateTableSource x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlAlterTableAlterColumn x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlAlterTableAlterColumn x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlSubPartitionByKey x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlSubPartitionByKey x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlSubPartitionByList x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlSubPartitionByList x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlDeclareHandlerStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlDeclareHandlerStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(MySqlDeclareConditionStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(MySqlDeclareConditionStatement x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLAllColumnExpr x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLBetweenExpr x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLBinaryOpExpr x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLCaseExpr x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLCaseExpr.Item x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLCharExpr x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLIdentifierExpr x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLInListExpr x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLIntegerExpr x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLExistsExpr x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLNCharExpr x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLNotExpr x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLNullExpr x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLNumberExpr x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLPropertyExpr x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLSelectGroupByClause x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLSelectItem x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLSelectStatement selectStatement) {
        super.endVisit(selectStatement);
    }

    @Override
    public void postVisit(SQLObject astNode) {
        super.postVisit(astNode);
    }

    @Override
    public void preVisit(SQLObject astNode) {
        super.preVisit(astNode);
    }

    @Override
    public boolean visit(SQLAllColumnExpr x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLBetweenExpr x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLBinaryOpExpr x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLCaseExpr x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLCaseExpr.Item x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLCastExpr x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLCharExpr x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLExistsExpr x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLIdentifierExpr x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLInListExpr x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLIntegerExpr x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLNCharExpr x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLNotExpr x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLNullExpr x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLNumberExpr x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLPropertyExpr x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLSelectGroupByClause x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLSelectItem x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLCastExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLSelectStatement astNode) {
        return super.visit(astNode);
    }

    @Override
    public void endVisit(SQLAggregateExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAggregateExpr x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLVariantRefExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLVariantRefExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLQueryExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLQueryExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLSelect x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLSelect select) {
        super.endVisit(select);
    }

    @Override
    public boolean visit(SQLSelectQueryBlock x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLSelectQueryBlock x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLExprTableSource x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLExprTableSource x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLOrderBy x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLOrderBy x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLSelectOrderByItem x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLSelectOrderByItem x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLDropTableStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLDropTableStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLCreateTableStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLCreateTableStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLColumnDefinition x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLColumnDefinition x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLColumnDefinition.Identity x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLColumnDefinition.Identity x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLDataType x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLDataType x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLDeleteStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLDeleteStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLCurrentOfCursorExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLCurrentOfCursorExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLInsertStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLInsertStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLUpdateSetItem x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLUpdateSetItem x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLUpdateStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLUpdateStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLCreateViewStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLCreateViewStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLCreateViewStatement.Column x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLCreateViewStatement.Column x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLNotNullConstraint x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLNotNullConstraint x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLMethodInvokeExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLMethodInvokeExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLUnionQuery x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLUnionQuery x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLUnaryExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLUnaryExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLHexExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLHexExpr x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLSetStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLSetStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAssignItem x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAssignItem x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLCallStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLCallStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLJoinTableSource x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLJoinTableSource x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLInsertStatement.ValuesClause x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLInsertStatement.ValuesClause x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLSomeExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLSomeExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAnyExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAnyExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAllExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAllExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLInSubQueryExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLInSubQueryExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLListExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLListExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLSubqueryTableSource x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLSubqueryTableSource x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLTruncateStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLTruncateStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLDefaultExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLDefaultExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLCommentStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLCommentStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLUseStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLUseStatement x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLAlterTableAddColumn x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableAddColumn x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableDropColumnItem x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableDropColumnItem x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLDropIndexStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLDropIndexStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLDropViewStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLDropViewStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLSavePointStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLSavePointStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLRollbackStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLRollbackStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLReleaseSavePointStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLReleaseSavePointStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLCommentHint x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLCommentHint x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLCreateDatabaseStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLCreateDatabaseStatement x) {
        CreateDababaseHander.handle(x, connection);
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLAlterTableDropIndex x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableDropIndex x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLOver x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLOver x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLKeep x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLKeep x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLColumnPrimaryKey x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLColumnPrimaryKey x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLColumnUniqueKey x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLColumnUniqueKey x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLWithSubqueryClause x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLWithSubqueryClause x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLWithSubqueryClause.Entry x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLWithSubqueryClause.Entry x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLCharacterDataType x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLCharacterDataType x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLAlterTableAlterColumn x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableAlterColumn x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLCheck x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLCheck x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableDropForeignKey x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableDropForeignKey x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableDropPrimaryKey x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableDropPrimaryKey x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableDisableKeys x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableDisableKeys x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableEnableKeys x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableEnableKeys x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableDisableConstraint x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableDisableConstraint x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableEnableConstraint x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableEnableConstraint x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLColumnCheck x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLColumnCheck x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLExprHint x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLExprHint x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableDropConstraint x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableDropConstraint x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLUnique x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLUnique x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLCreateIndexStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLCreateIndexStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLPrimaryKeyImpl x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLPrimaryKeyImpl x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableRenameColumn x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableRenameColumn x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLColumnReference x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLColumnReference x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLForeignKeyImpl x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLForeignKeyImpl x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLDropSequenceStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLDropSequenceStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLDropTriggerStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLDropTriggerStatement x) {
        super.endVisit(x);
    }

    @Override
    public void endVisit(SQLDropUserStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLDropUserStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLExplainStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLExplainStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLGrantStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLGrantStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLDropDatabaseStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLDropDatabaseStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableAddIndex x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableAddIndex x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableAddConstraint x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableAddConstraint x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLCreateTriggerStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLCreateTriggerStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLDropFunctionStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLDropFunctionStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLDropTableSpaceStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLDropTableSpaceStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLDropProcedureStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLDropProcedureStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLBooleanExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLBooleanExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLUnionQueryTableSource x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLUnionQueryTableSource x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLTimestampExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLTimestampExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLRevokeStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLRevokeStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLBinaryExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLBinaryExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableRename x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableRename x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterViewRenameStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterViewRenameStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLShowTablesStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLShowTablesStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableAddPartition x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableAddPartition x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableDropPartition x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableDropPartition x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableRenamePartition x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableRenamePartition x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableSetComment x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableSetComment x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableSetLifecycle x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableSetLifecycle x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableEnableLifecycle x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableEnableLifecycle x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableDisableLifecycle x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableDisableLifecycle x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableTouch x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableTouch x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLArrayExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLArrayExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLOpenStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLOpenStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLFetchStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLFetchStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLCloseStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLCloseStatement x) {
        return super.visit(x);
    }

    @Override
    public boolean visit(SQLGroupingSetExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLGroupingSetExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLIfStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLIfStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLIfStatement.Else x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLIfStatement.Else x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLIfStatement.ElseIf x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLIfStatement.ElseIf x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLLoopStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLLoopStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLParameter x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLParameter x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLCreateProcedureStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLCreateProcedureStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLBlockStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLBlockStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableDropKey x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableDropKey x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLDeclareItem x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLDeclareItem x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLPartitionValue x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLPartitionValue x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLPartition x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLPartition x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLPartitionByRange x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLPartitionByRange x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLPartitionByHash x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLPartitionByHash x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLPartitionByList x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLPartitionByList x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLSubPartition x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLSubPartition x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLSubPartitionByHash x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLSubPartitionByHash x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLSubPartitionByList x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLSubPartitionByList x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterDatabaseStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterDatabaseStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableConvertCharSet x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableConvertCharSet x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableReOrganizePartition x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableReOrganizePartition x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableCoalescePartition x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableCoalescePartition x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableTruncatePartition x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableTruncatePartition x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableDiscardPartition x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableDiscardPartition x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableImportPartition x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableImportPartition x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableAnalyzePartition x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableAnalyzePartition x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableCheckPartition x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableCheckPartition x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableOptimizePartition x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableOptimizePartition x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableRebuildPartition x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableRebuildPartition x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLAlterTableRepairPartition x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLAlterTableRepairPartition x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLSequenceExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLSequenceExpr x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLMergeStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLMergeStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLMergeStatement.MergeUpdateClause x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLMergeStatement.MergeUpdateClause x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLMergeStatement.MergeInsertClause x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLMergeStatement.MergeInsertClause x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLErrorLoggingClause x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLErrorLoggingClause x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLNullConstraint x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLNullConstraint x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLCreateSequenceStatement x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLCreateSequenceStatement x) {
        super.endVisit(x);
    }

    @Override
    public boolean visit(SQLDateExpr x) {
        return super.visit(x);
    }

    @Override
    public void endVisit(SQLDateExpr x) {
        super.endVisit(x);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
