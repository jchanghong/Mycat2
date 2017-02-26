package io.mycat.orientserver.parser;

import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.ast.clause.*;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlASTVisitorAdapter;
import io.mycat.orientserver.OConnection;
import io.mycat.orientserver.handler.DefaultHander;
import io.mycat.orientserver.handler.adminstatement.ShowHandler;
import io.mycat.orientserver.handler.data_define.CreateDababaseHander;
import io.mycat.orientserver.handler.data_define.CreateTable;
import io.mycat.orientserver.handler.data_mannipulation.SelectHandler;
import io.mycat.orientserver.handler.utilstatement.Usedatabase;

import static io.mycat.orientserver.handler.adminstatement.ShowHandler.showfunctionstatus;

public class SQLvisitor extends MySqlASTVisitorAdapter {
    OConnection connection;

    public SQLvisitor(OConnection connection) {
        this.connection = connection;
    }

    @Override
    public void endVisit(MySqlPrepareStatement x) {
        super.endVisit(x);
        DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlExecuteStatement x) {
        super.endVisit(x);
        DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MysqlDeallocatePrepareStatement x) {
        super.endVisit(x);
        DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlDeleteStatement x) {
        super.endVisit(x); DefaultHander.handle(  x, connection);
    }

    @Override
    public void endVisit(MySqlInsertStatement x) {
        super.endVisit(x); DefaultHander.handle(  x, connection);
    }

    @Override
    public void endVisit(MySqlLoadDataInFileStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlLoadXmlStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlReplaceStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlStartTransactionStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlCommitStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlRollbackStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlShowColumnsStatement x) {
        super.endVisit(x);
        ShowHandler.showcolumn(x);
    }

    @Override
    public void endVisit(MySqlShowDatabasesStatement x) {
        super.endVisit(x);
        ShowHandler.showdatabase(x, connection);
    }

    @Override
    public void endVisit(MySqlShowWarningsStatement x) {
        super.endVisit(x);
        ShowHandler.showwarnings(x);
    }

    @Override
    public void endVisit(MySqlShowStatusStatement x) {
        super.endVisit(x);
        ShowHandler.showstatus(x);
    }

    @Override
    public void endVisit(MySqlKillStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlBinlogStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlResetStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlCreateUserStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }




    @Override
    public void endVisit(MySqlDescribeStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlUpdateStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlSetTransactionStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlSetNamesStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlSetCharSetStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlShowAuthorsStatement x) {
        super.endVisit(x);
        ShowHandler.showauthors(x);
    }

    @Override
    public void endVisit(MySqlShowBinaryLogsStatement x) {
        super.endVisit(x);
        ShowHandler.showbinarylogs(x);
    }

    @Override
    public void endVisit(MySqlShowMasterLogsStatement x) {
        super.endVisit(x);
        ShowHandler.showmasterlogs(x);
    }

    @Override
    public void endVisit(MySqlShowCollationStatement x) {
        super.endVisit(x);
        ShowHandler.showcollation(x);
    }

    @Override
    public void endVisit(MySqlShowBinLogEventsStatement x) {
        super.endVisit(x);
        ShowHandler.showbinlogevent(x);
    }

    @Override
    public void endVisit(MySqlShowCharacterSetStatement x) {
        super.endVisit(x);
        ShowHandler.showcharater(x);
    }

    @Override
    public void endVisit(MySqlShowContributorsStatement x) {
        super.endVisit(x);
        ShowHandler.showcontributors(x);
    }

    @Override
    public void endVisit(MySqlShowCreateDatabaseStatement x) {
        super.endVisit(x);
        ShowHandler.showcreatedatabase(x);
    }

    @Override
    public void endVisit(MySqlShowCreateEventStatement x) {
        super.endVisit(x);
        ShowHandler.showcreateevent(x);
    }

    @Override
    public void endVisit(MySqlShowCreateFunctionStatement x) {
        super.endVisit(x);
        ShowHandler.showcreatefunction(x);
    }

    @Override
    public void endVisit(MySqlShowCreateProcedureStatement x) {
        super.endVisit(x);
        ShowHandler.showcreateproccedure(x);
    }

    @Override
    public void endVisit(MySqlShowCreateTableStatement x) {
        super.endVisit(x);
        ShowHandler.showcreatetable(x);
    }

    @Override
    public void endVisit(MySqlShowCreateTriggerStatement x) {
        super.endVisit(x);
        ShowHandler.showcreatetrigger(x);
    }

    @Override
    public void endVisit(MySqlShowCreateViewStatement x) {
        super.endVisit(x);
        ShowHandler.showcreateview(x);
    }

    @Override
    public void endVisit(MySqlShowEngineStatement x) {
        super.endVisit(x);
        ShowHandler.showengine(x);
    }

    @Override
    public void endVisit(MySqlShowEnginesStatement x) {
        super.endVisit(x);
        ShowHandler.showengines(x);
    }

    @Override
    public void endVisit(MySqlShowErrorsStatement x) {
        super.endVisit(x);
        ShowHandler.showerrors(x);
    }

    @Override
    public void endVisit(MySqlShowEventsStatement x) {
        super.endVisit(x);
        ShowHandler.showevents(x);
    }

    @Override
    public void endVisit(MySqlShowFunctionCodeStatement x) {
        super.endVisit(x);
        ShowHandler.showfunctioncode(x);
    }

    @Override
    public void endVisit(MySqlShowFunctionStatusStatement x) {
        super.endVisit(x);
        showfunctionstatus(x);
    }

    @Override
    public void endVisit(MySqlShowGrantsStatement x) {
        super.endVisit(x);
        ShowHandler.showgrants(x);
    }

    @Override
    public void endVisit(MySqlShowIndexesStatement x) {
        super.endVisit(x);
        ShowHandler.showindexs(x);
    }

    @Override
    public void endVisit(MySqlShowKeysStatement x) {
        super.endVisit(x);
        ShowHandler.showkeys(x);
    }

    @Override
    public void endVisit(MySqlShowMasterStatusStatement x) {
        super.endVisit(x);
        ShowHandler.showmasterstatus(x);
    }

    @Override
    public void endVisit(MySqlShowOpenTablesStatement x) {
        super.endVisit(x);
        ShowHandler.showopentable(x);
    }

    @Override
    public void endVisit(MySqlShowPluginsStatement x) {
        super.endVisit(x);
        ShowHandler.showplugins(x);
    }

    @Override
    public void endVisit(MySqlShowPrivilegesStatement x) {
        super.endVisit(x);
        ShowHandler.showprivileges(x);
    }

    @Override
    public void endVisit(MySqlShowProcedureCodeStatement x) {
        super.endVisit(x);
        ShowHandler.showprovedureode(x);
    }

    @Override
    public void endVisit(MySqlShowProcedureStatusStatement x) {
        super.endVisit(x);
        ShowHandler.showproedurestatus(x);
    }

    @Override
    public void endVisit(MySqlShowProcessListStatement x) {
        super.endVisit(x);
        ShowHandler.showprocesslist(x);
    }

    @Override
    public void endVisit(MySqlShowProfileStatement x) {
        super.endVisit(x);
        ShowHandler.showprofile(x);
    }

    @Override
    public void endVisit(MySqlShowProfilesStatement x) {
        super.endVisit(x);
        ShowHandler.showprofiles(x);
    }

    @Override
    public void endVisit(MySqlShowRelayLogEventsStatement x) {
        super.endVisit(x);
        ShowHandler.showrelaylog(x);
    }

    @Override
    public void endVisit(MySqlShowSlaveHostsStatement x) {
        super.endVisit(x);
        ShowHandler.showslavehosts(x);
    }

    @Override
    public void endVisit(MySqlShowSlaveStatusStatement x) {
        super.endVisit(x);
        ShowHandler.showslavestatus(x);
    }

    @Override
    public void endVisit(MySqlShowTableStatusStatement x) {
        super.endVisit(x);
        ShowHandler.showtablestatus(x);
    }

    @Override
    public void endVisit(MySqlShowTriggersStatement x) {
        super.endVisit(x);
        ShowHandler.showtriggers(x);
    }

    @Override
    public void endVisit(MySqlShowVariantsStatement x) {
        super.endVisit(x);
        ShowHandler.showvatiants(x, connection);
    }

    @Override
    public void endVisit(MySqlRenameTableStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }


    @Override
    public void endVisit(MySqlLockTableStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlUnlockTablesStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlCreateTableStatement x) {
        super.endVisit(x);
        CreateTable.handle(x, connection);
//        DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlHelpStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlAnalyzeStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlAlterUserStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlOptimizeStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlSetPasswordStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlHintStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }



    @Override
    public void endVisit(MySqlWhileStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlCaseStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlDeclareStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlSelectIntoStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

//    @Override
//    public void endVisit(MySqlCaseStatement.MySqlWhenStatement x) {
//        super.endVisit(x); DefaultHander.handle(  x, connection);
//    }

    @Override
    public void endVisit(MySqlLeaveStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlIterateStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlRepeatStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlCursorDeclareStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlDeclareHandlerStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(MySqlDeclareConditionStatement x) {
        super.endVisit(x); DefaultHander.handle(x, connection);
    }


    @Override
    public void endVisit(SQLSelectStatement selectStatement) {
        super.endVisit(selectStatement);
        SelectHandler.handle(selectStatement, connection);
    }

    @Override
    public void endVisit(SQLDropTableStatement x) {
        super.endVisit(x);DefaultHander.handle( x, connection);
    }

    @Override
    public void endVisit(SQLCreateTableStatement x) {
        super.endVisit(x);
        DefaultHander.handle(  x, connection);
    }

    @Override
    public void endVisit(SQLDeleteStatement x) {
        super.endVisit(x);DefaultHander.handle(  x, connection);
    }

    @Override
    public void endVisit(SQLInsertStatement x) {
        super.endVisit(x);
//        DefaultHander.handle(  x, connection);
    }

    @Override
    public void endVisit(SQLUpdateStatement x) {
        super.endVisit(x);DefaultHander.handle(  x, connection);
    }

    @Override
    public void endVisit(SQLCreateViewStatement x) {
        super.endVisit(x);DefaultHander.handle(  x, connection);
    }

    @Override
    public void endVisit(SQLSetStatement x) {
        super.endVisit(x);DefaultHander.handle(  x, connection);
    }

    @Override
    public void endVisit(SQLCallStatement x) {
        super.endVisit(x);DefaultHander.handle(  x, connection);
    }

    @Override
    public void endVisit(SQLTruncateStatement x) {
        super.endVisit(x);DefaultHander.handle(  x, connection);
    }

    @Override
    public void endVisit(SQLCommentStatement x) {
        super.endVisit(x);DefaultHander.handle(  x, connection);
    }

    @Override
    public void endVisit(SQLUseStatement x) {
        super.endVisit(x);
        Usedatabase.handle(x, connection);
    }

    @Override
    public void endVisit(SQLDropIndexStatement x) {
        super.endVisit(x);DefaultHander.handle(  x, connection);
    }

    @Override
    public void endVisit(SQLDropViewStatement x) {
        super.endVisit(x);DefaultHander.handle(  x, connection);
    }

    @Override
    public void endVisit(SQLSavePointStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLRollbackStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLReleaseSavePointStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLCreateDatabaseStatement x) {
        super.endVisit(x);
        CreateDababaseHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLAlterTableStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLCreateIndexStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLDropSequenceStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLDropTriggerStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLDropUserStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLExplainStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLGrantStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLDropDatabaseStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLCreateTriggerStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLDropFunctionStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLDropTableSpaceStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLDropProcedureStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLRevokeStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLAlterViewRenameStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLShowTablesStatement x) {
        super.endVisit(x);
        ShowHandler.showtables(x, connection);
    }

    @Override
    public void endVisit(SQLOpenStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLFetchStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLCloseStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLIfStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLLoopStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLCreateProcedureStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLBlockStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLAlterDatabaseStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLMergeStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }

    @Override
    public void endVisit(SQLCreateSequenceStatement x) {
        super.endVisit(x);DefaultHander.handle(x, connection);
    }
}