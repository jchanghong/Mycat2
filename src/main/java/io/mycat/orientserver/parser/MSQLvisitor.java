package io.mycat.orientserver.parser;

import com.alibaba.druid.sql.ast.*;
import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.ast.*;
import com.alibaba.druid.sql.dialect.mysql.ast.clause.*;
import com.alibaba.druid.sql.dialect.mysql.ast.expr.MySqlUserName;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlASTVisitorAdapter;
import io.mycat.orientserver.OConnection;
import io.mycat.orientserver.handler.adminstatement.MSetHandler;
import io.mycat.orientserver.handler.adminstatement.ShowHandler;
import io.mycat.orientserver.handler.data_define.*;
import io.mycat.orientserver.handler.data_mannipulation.*;
import io.mycat.orientserver.handler.utilstatement.HelpStatement;
import io.mycat.orientserver.handler.utilstatement.Usedatabase;
import io.mycat.orientserver.response.MShowTables;

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
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlTableIndex x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlKey x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlPrimaryKey x) {
        connection.writeok();
        return false;
    }





    @Override
    public boolean visit(MySqlPrepareStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlExecuteStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MysqlDeallocatePrepareStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlDeleteStatement x) {
        Mdelete.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlInsertStatement x) {
        Minsert.handle(x, connection);
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
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlStartTransactionStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlCommitStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlRollbackStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlShowColumnsStatement x) {
        ShowHandler.showcolumn(x,connection);
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
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlKillStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlBinlogStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlResetStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlCreateUserStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlCreateUserStatement.UserSpecification x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlPartitionByKey x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlSelectQueryBlock x) {
        connection.writeok();
        return false;
    }


    @Override
    public boolean visit(MySqlDescribeStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlUpdateStatement x) {
        Mupdate.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlSetTransactionStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlSetNamesStatement x) {
       
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlSetCharSetStatement x) {
        connection.writeok();
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
        connection.writeok();
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

    /*SHOW VARIABLES WHERE Variable_name = 'language'
OR Variable_name = 'net_write_timeout'
OR Variable_name = 'interactive_timeout'
OR Variable_name = 'wait_timeout'
OR Variable_name = 'character_set_client'
OR Variable_name = 'character_set_connection'
OR Variable_name = 'character_set'
OR Variable_name = 'character_set_server'
OR Variable_name = 'tx_isolation'
OR Variable_name = 'transaction_isolation'
OR Variable_name = 'character_set_results'
OR Variable_name = 'timezone'
OR Variable_name = 'time_zone'
OR Variable_name = 'system_time_zone'
OR Variable_name = 'lower_case_table_names'
OR Variable_name = 'max_allowed_packet'
OR Variable_name = 'net_buffer_length'
OR Variable_name = 'sql_mode'
OR Variable_name = 'query_cache_type'
OR Variable_name = 'query_cache_size'
OR Variable_name = 'license'
OR Variable_name = 'init_connect'*/
    @Override
    public boolean visit(MySqlShowVariantsStatement x) {
        ShowHandler.showvatiants(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlRenameTableStatement.Item x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlRenameTableStatement x) {
        RenameTable.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(MySqlUnionQuery x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlUseIndexHint x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlIgnoreIndexHint x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlLockTableStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlUnlockTablesStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlForceIndexHint x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlAlterTableChangeColumn x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlAlterTableCharacter x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlAlterTableOption x) {
        connection.writeok();
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
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MysqlForeignKey x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlAlterTableModifyColumn x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlAlterTableDiscardTablespace x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlAlterTableImportTablespace x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlCreateTableStatement.TableSpaceOption x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlAnalyzeStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlAlterUserStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlOptimizeStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlSetPasswordStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlHintStatement x) {
        connection.writeok();
        return false;
    }


    @Override
    public boolean visit(MySqlWhileStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlCaseStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlDeclareStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlSelectIntoStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlCaseStatement.MySqlWhenStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlLeaveStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlIterateStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlRepeatStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlCursorDeclareStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlUpdateTableSource x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlAlterTableAlterColumn x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlSubPartitionByKey x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlSubPartitionByList x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlDeclareHandlerStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(MySqlDeclareConditionStatement x) {
        connection.writeok();
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
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLColumnDefinition x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLColumnDefinition.Identity x) {
        connection.writeok();
        return false;
    }



    @Override
    public boolean visit(SQLCreateViewStatement x) {
        CreateView.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLCreateViewStatement.Column x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAssignItem x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLCallStatement x) {
        Mcall.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLCommentStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAddColumn x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropColumnItem x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLCommentHint x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLCreateDatabaseStatement x) {
        CreateDababaseHander.handle(x,connection);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropIndex x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLColumnPrimaryKey x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLColumnUniqueKey x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLWithSubqueryClause.Entry x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLCharacterDataType x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAlterColumn x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLCheck x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropForeignKey x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropPrimaryKey x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDisableKeys x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableEnableKeys x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDisableConstraint x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableEnableConstraint x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLColumnCheck x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropConstraint x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLCreateIndexStatement x) {
        CreateIndex.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRenameColumn x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLColumnReference x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAddIndex x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAddConstraint x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLCreateTriggerStatement x) {
        CreateTrigger.handle(x, connection);
        return false;
    }



    @Override
    public boolean visit(SQLAlterTableRename x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterViewRenameStatement x) {
        AlterView.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAddPartition x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropPartition x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRenamePartition x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableSetComment x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableSetLifecycle x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableEnableLifecycle x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDisableLifecycle x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableTouch x) {
        connection.writeok();
        return false;
    }



    @Override
    public boolean visit(SQLCloseStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLIfStatement.Else x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLIfStatement.ElseIf x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLCreateProcedureStatement x) {
        CreateProcedure_function.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLBlockStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDropKey x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterDatabaseStatement x) {
        AlterDatabase.handle(x,connection);
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableConvertCharSet x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableReOrganizePartition x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableCoalescePartition x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableTruncatePartition x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableDiscardPartition x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableImportPartition x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableAnalyzePartition x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableCheckPartition x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableOptimizePartition x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRebuildPartition x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLAlterTableRepairPartition x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLMergeStatement.MergeUpdateClause x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLMergeStatement.MergeInsertClause x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLCreateSequenceStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public void endVisit(MySqlRenameTableStatement.Item x) {
        super.endVisit(x);
    }



    @Override
    public boolean visit(SQLSelectGroupByClause x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLSelectItem x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLSelect x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLSelectQueryBlock x) {
        connection.writeok();
        return false;
    }



    @Override
    public boolean visit(SQLOrderBy x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLSelectOrderByItem x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLDropTableStatement x) {
        DropTable.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLDataType x) {
        connection.writeok();
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
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLUpdateStatement x) {
        Mupdate.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLNotNullConstraint x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLUnionQuery x) {
        connection.writeok();
        return false;
    }


    @Override
    public boolean visit(SQLSetStatement x) {
        MSetHandler.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLJoinTableSource x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLInsertStatement.ValuesClause x) {
        connection.writeok();
        return false;
    }


    @Override
    public boolean visit(SQLSubqueryTableSource x) {
        connection.writeok();
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
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLRollbackStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLReleaseSavePointStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLOver x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLKeep x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLWithSubqueryClause x) {
        connection.writeok();
        return false;
    }



    @Override
    public boolean visit(SQLUnique x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLPrimaryKeyImpl x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLForeignKeyImpl x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLDropSequenceStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLDropTriggerStatement x) {
        Droptrigger.handle(x, connection);
        return false;
    }

    @Override
    public boolean visit(SQLDropUserStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLExplainStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLGrantStatement x) {
        connection.writeok();
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
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLUnionQueryTableSource x) {
        connection.writeok();
        return false;
    }


    @Override
    public boolean visit(SQLRevokeStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLShowTablesStatement x) {
        MShowTables.response(connection, x, 1);
        return false;
    }

    @Override
    public boolean visit(SQLOpenStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLFetchStatement x) {
        connection.writeok();
        return false;
    }


    @Override
    public boolean visit(SQLIfStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLLoopStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLParameter x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLDeclareItem x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLPartitionValue x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLPartition x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLPartitionByRange x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLPartitionByHash x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLPartitionByList x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLSubPartition x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLSubPartitionByHash x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLSubPartitionByList x) {
        connection.writeok();
        return false;
    }



    @Override
    public boolean visit(SQLMergeStatement x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLErrorLoggingClause x) {
        connection.writeok();
        return false;
    }

    @Override
    public boolean visit(SQLNullConstraint x) {
        connection.writeok();
        return false;
    }

}
