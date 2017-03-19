package io.mycat.orientserver.parser;

import com.alibaba.druid.sql.ast.*;
import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.ast.*;
import com.alibaba.druid.sql.dialect.mysql.ast.clause.*;
import com.alibaba.druid.sql.dialect.mysql.ast.expr.MySqlUserName;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlASTVisitorAdapter;
import io.mycat.orientserver.OConnection;
import io.mycat.orientserver.handler.adminstatement.ShowHandler;
import io.mycat.orientserver.handler.data_define.*;
import io.mycat.orientserver.handler.data_mannipulation.*;
import io.mycat.orientserver.handler.utilstatement.HelpStatement;
import io.mycat.orientserver.handler.utilstatement.Usedatabase;
import io.mycat.orientserver.response.ShowTables;

/**
 * Created by 长宏 on 2017/3/19 0019.
 */
public class MSQLvisitor extends MySqlASTVisitorAdapter {
    private OConnection connection;

    public MSQLvisitor(OConnection connection) {
        this.connection = connection;
    }

    @Override
    public boolean visit(MySqlSelectQueryBlock.Limit x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlTableIndex x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlKey x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlPrimaryKey x) {
        connection.writeNotSurrport();
        return false;
    }





    @Override
    public boolean visit(MySqlPrepareStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlExecuteStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MysqlDeallocatePrepareStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlDeleteStatement x) {
        Mdelete.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlInsertStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlLoadDataInFileStatement x) {
        MloaddataINfile.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlLoadXmlStatement x) {
        Mloadxml.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlReplaceStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlStartTransactionStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlCommitStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlRollbackStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlShowColumnsStatement x) {
        ShowHandler.showcolumn(x);

        return false;
    }

    @Override
    public boolean visit(MySqlShowDatabasesStatement x) {
        ShowHandler.showdatabase(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowWarningsStatement x) {
        ShowHandler.showwarnings(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowStatusStatement x) {
        ShowHandler.showstatus(x, connection);
        return false;
    }

    @Override
    public boolean visit(CobarShowStatus x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlKillStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlBinlogStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlResetStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlCreateUserStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlCreateUserStatement.UserSpecification x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlPartitionByKey x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlSelectQueryBlock x) {
        connection.writeNotSurrport();
        return false;
    }


    @Override
    public boolean visit(MySqlDescribeStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlUpdateStatement x) {
        Mupdate.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlSetTransactionStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlSetNamesStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlSetCharSetStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlShowAuthorsStatement x) {
        ShowHandler.showauthors(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowBinaryLogsStatement x) {
        ShowHandler.showbinarylogs(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowMasterLogsStatement x) {
        ShowHandler.showmasterlogs(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowCollationStatement x) {
        ShowHandler.showcollation(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowBinLogEventsStatement x) {
        ShowHandler.showbinlogevent(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowCharacterSetStatement x) {
        ShowHandler.showcharater(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowContributorsStatement x) {
       ShowHandler.showcontributors(x,connection);

        return false;
    }

    @Override
    public boolean visit(MySqlShowCreateDatabaseStatement x) {
        ShowHandler.showcreatedatabase(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowCreateEventStatement x) {
        ShowHandler.showcreateevent(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowCreateFunctionStatement x) {
        ShowHandler.showcreatefunction(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowCreateProcedureStatement x) {
        ShowHandler.showcreateproccedure(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowCreateTableStatement x) {
        ShowHandler.showcreatetable(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowCreateTriggerStatement x) {
        ShowHandler.showcreatetrigger(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowCreateViewStatement x) {
        ShowHandler.showcreateview(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowEngineStatement x) {
        ShowHandler.showengine(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowEnginesStatement x) {
        ShowHandler.showengines(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowErrorsStatement x) {
        ShowHandler.showerrors(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowEventsStatement x) {
        ShowHandler.showevents(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowFunctionCodeStatement x) {
        ShowHandler.showfunctioncode(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowFunctionStatusStatement x) {
        ShowHandler.showfunctionstatus(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowGrantsStatement x) {
        ShowHandler.showgrants(x, connection);

        return false;
    }

    @Override
    public boolean visit(MySqlUserName x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlShowIndexesStatement x) {
        ShowHandler.showindexs(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowKeysStatement x) {
        ShowHandler.showkeys(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowMasterStatusStatement x) {
        ShowHandler.showmasterstatus(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowOpenTablesStatement x) {
        ShowHandler.showopentable(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowPluginsStatement x) {
        ShowHandler.showplugins(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowPrivilegesStatement x) {
        ShowHandler.showprivileges(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowProcedureCodeStatement x) {
        ShowHandler.showprovedureode(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowProcedureStatusStatement x) {
        ShowHandler.showproedurestatus(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowProcessListStatement x) {
        ShowHandler.showprocesslist(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowProfileStatement x) {
        ShowHandler.showprofile(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowProfilesStatement x) {
        ShowHandler.showprofiles(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowRelayLogEventsStatement x) {
        ShowHandler.showrelaylog(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowSlaveHostsStatement x) {
        ShowHandler.showslavehosts(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowSlaveStatusStatement x) {
        ShowHandler.showslavestatus(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowTableStatusStatement x) {
        ShowHandler.showtablestatus(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowTriggersStatement x) {
        ShowHandler.showtriggers(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlShowVariantsStatement x) {
        ShowHandler.showvatiants(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlRenameTableStatement.Item x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlRenameTableStatement x) {
        RenameTable.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlUnionQuery x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlUseIndexHint x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlIgnoreIndexHint x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlLockTableStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlUnlockTablesStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlForceIndexHint x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlAlterTableChangeColumn x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlAlterTableCharacter x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlAlterTableOption x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlCreateTableStatement x) {
        CreateTable.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlHelpStatement x) {
        HelpStatement.handle(x, connection);
        return false;
    }



    @Override
    public boolean visit(MySqlUnique x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MysqlForeignKey x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlAlterTableModifyColumn x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlAlterTableDiscardTablespace x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlAlterTableImportTablespace x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlCreateTableStatement.TableSpaceOption x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlAnalyzeStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlAlterUserStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlOptimizeStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlSetPasswordStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlHintStatement x) {
        connection.writeNotSurrport();
        return false;
    }


    @Override
    public boolean visit(MySqlWhileStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlCaseStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlDeclareStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlSelectIntoStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlCaseStatement.MySqlWhenStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlLeaveStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlIterateStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlRepeatStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlCursorDeclareStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlUpdateTableSource x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlAlterTableAlterColumn x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlSubPartitionByKey x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlSubPartitionByList x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlDeclareHandlerStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(MySqlDeclareConditionStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public void endVisit(CobarShowStatus x) {
        super.endVisit(x);
    }


    @Override
    public boolean visit(SQLSelectStatement astNode) {
        MSelectHandler.handle(astNode, connection);
        return false;
    }

    @Override
    public boolean visit(SQLCreateTableStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLColumnDefinition x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLColumnDefinition.Identity x) {
        connection.writeNotSurrport();
        return false;
    }



    @Override
    public boolean visit(SQLCreateViewStatement x) {
        CreateView.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLCreateViewStatement.Column x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAssignItem x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLCallStatement x) {
        Mcall.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLCommentStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAddColumn x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropColumnItem x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLCommentHint x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLCreateDatabaseStatement x) {
        CreateDababaseHander.handle(x,connection);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropIndex x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLColumnPrimaryKey x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLColumnUniqueKey x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLWithSubqueryClause.Entry x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLCharacterDataType x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAlterColumn x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLCheck x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropForeignKey x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropPrimaryKey x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDisableKeys x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableEnableKeys x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDisableConstraint x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableEnableConstraint x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLColumnCheck x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropConstraint x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLCreateIndexStatement x) {
        CreateIndex.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRenameColumn x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLColumnReference x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAddIndex x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAddConstraint x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLCreateTriggerStatement x) {
        CreateTrigger.handle(x, connection);
        return false;
    }



    @Override
    public boolean visit(SQLAlterTableRename x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterViewRenameStatement x) {
        AlterView.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAddPartition x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropPartition x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRenamePartition x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableSetComment x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableSetLifecycle x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableEnableLifecycle x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDisableLifecycle x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableTouch x) {
        connection.writeNotSurrport();
        return false;
    }



    @Override
    public boolean visit(SQLCloseStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLIfStatement.Else x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLIfStatement.ElseIf x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLCreateProcedureStatement x) {
        CreateProcedure_function.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLBlockStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropKey x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterDatabaseStatement x) {
        AlterDatabase.handle(x,connection);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableConvertCharSet x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableReOrganizePartition x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableCoalescePartition x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableTruncatePartition x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDiscardPartition x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableImportPartition x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAnalyzePartition x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableCheckPartition x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableOptimizePartition x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRebuildPartition x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRepairPartition x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLMergeStatement.MergeUpdateClause x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLMergeStatement.MergeInsertClause x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLCreateSequenceStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public void endVisit(MySqlRenameTableStatement.Item x) {
        super.endVisit(x);
    }



    @Override
    public boolean visit(SQLSelectGroupByClause x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLSelectItem x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLSelect x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLSelectQueryBlock x) {
        connection.writeNotSurrport();
        return false;
    }



    @Override
    public boolean visit(SQLOrderBy x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLSelectOrderByItem x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLDropTableStatement x) {
        DropTable.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLDataType x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLDeleteStatement x) {
        Mdelete.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLInsertStatement x) {
        Minsert.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLUpdateSetItem x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLUpdateStatement x) {
        Mupdate.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLNotNullConstraint x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLUnionQuery x) {
        connection.writeNotSurrport();
        return false;
    }



    @Override
    public boolean visit(SQLSetStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLJoinTableSource x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLInsertStatement.ValuesClause x) {
        connection.writeNotSurrport();
        return false;
    }


    @Override
    public boolean visit(SQLSubqueryTableSource x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLTruncateStatement x) {
        TruncteTable.handle(x, connection);
        return false;
    }



    @Override
    public boolean visit(SQLUseStatement x) {
        Usedatabase.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLDropIndexStatement x) {
        DropIndex.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLDropViewStatement x) {
        DropView.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLSavePointStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLRollbackStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLReleaseSavePointStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLOver x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLKeep x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLWithSubqueryClause x) {
        connection.writeNotSurrport();
        return false;
    }



    @Override
    public boolean visit(SQLUnique x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLPrimaryKeyImpl x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLForeignKeyImpl x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLDropSequenceStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLDropTriggerStatement x) {
        Droptrigger.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLDropUserStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLExplainStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLGrantStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLDropDatabaseStatement x) {
        DropDatabase.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLDropFunctionStatement x) {
        DropProcedure_function.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLDropTableSpaceStatement x) {
        DropTABLEspace.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLDropProcedureStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLUnionQueryTableSource x) {
        connection.writeNotSurrport();
        return false;
    }


    @Override
    public boolean visit(SQLRevokeStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLShowTablesStatement x) {
        ShowTables.response(connection, x.toString(), 1);
        return false;
    }

    @Override
    public boolean visit(SQLOpenStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLFetchStatement x) {
        connection.writeNotSurrport();
        return false;
    }


    @Override
    public boolean visit(SQLIfStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLLoopStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLParameter x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLDeclareItem x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLPartitionValue x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLPartition x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLPartitionByRange x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLPartitionByHash x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLPartitionByList x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLSubPartition x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLSubPartitionByHash x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLSubPartitionByList x) {
        connection.writeNotSurrport();
        return false;
    }



    @Override
    public boolean visit(SQLMergeStatement x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLErrorLoggingClause x) {
        connection.writeNotSurrport();
        return false;
    }

    @Override
    public boolean visit(SQLNullConstraint x) {
        connection.writeNotSurrport();
        return false;
    }

}
