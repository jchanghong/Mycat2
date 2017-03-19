/*
 * Copyright (c) 2013, OpenCloudDB/MyCAT and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software;Designed and Developed mainly by many Chinese 
 * opensource volunteers. you can redistribute it and/or modify it under the 
 * terms of the GNU General Public License version 2 only, as published by the
 * Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 * Any questions about this component can be directed to it's project Web address 
 * https://code.google.com/p/opencloudb/.
 *
 */
package io.mycat.orientserver.handler.adminstatement;

import com.alibaba.druid.sql.ast.statement.SQLShowTablesStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.*;
import io.mycat.orientserver.OConnection;
import io.mycat.orientserver.response.*;

/**
 * @author changhong show开头的语句
 */
public final class ShowHandler {

    public static void showcolumn(MySqlShowColumnsStatement x) {
    }

    public static void showdatabase(MySqlShowDatabasesStatement x, OConnection c) {
        ShowDatabases.response(c);
    }

    public static void showwarnings(MySqlShowWarningsStatement x, OConnection connection) {
    }

    public static void showstatus(MySqlShowStatusStatement x, OConnection connection) {
    }

    public static void showauthors(MySqlShowAuthorsStatement x, OConnection connection) {
    }

    public static void showbinarylogs(MySqlShowBinaryLogsStatement x, OConnection connection) {
    }

    public static void showmasterlogs(MySqlShowMasterLogsStatement x, OConnection connection) {
    }

    public static void showcollation(MySqlShowCollationStatement x, OConnection connection) {
    }

    public static void showbinlogevent(MySqlShowBinLogEventsStatement x, OConnection connection) {
    }

    public static void showcharater(MySqlShowCharacterSetStatement x, OConnection connection) {
    }

    public static void showcontributors(MySqlShowContributorsStatement x, OConnection connection) {
    }

    public static void showcreatedatabase(MySqlShowCreateDatabaseStatement x, OConnection connection) {
    }

    public static void showcreateevent(MySqlShowCreateEventStatement x, OConnection connection) {
    }

    public static void showcreatefunction(MySqlShowCreateFunctionStatement x, OConnection connection) {
    }

    public static void showcreateproccedure(MySqlShowCreateProcedureStatement x, OConnection connection) {
    }

    public static void showcreatetable(MySqlShowCreateTableStatement x, OConnection connection) {
    }

    public static void showcreatetrigger(MySqlShowCreateTriggerStatement x, OConnection connection) {
    }

    public static void showcreateview(MySqlShowCreateViewStatement x, OConnection connection) {
    }

    public static void showengine(MySqlShowEngineStatement x, OConnection connection) {
    }

    public static void showengines(MySqlShowEnginesStatement x, OConnection connection) {
    }

    public static void showerrors(MySqlShowErrorsStatement x, OConnection connection) {
    }

    public static void showevents(MySqlShowEventsStatement x, OConnection connection) {
    }

    public static void showfunctioncode(MySqlShowFunctionCodeStatement x, OConnection connection) {
    }

    public static void showfunctionstatus(MySqlShowFunctionStatusStatement x, OConnection connection) {
    }

    public static void showgrants(MySqlShowGrantsStatement x, OConnection connection) {
    }

    public static void showindexs(MySqlShowIndexesStatement x, OConnection connection) {
    }

    public static void showkeys(MySqlShowKeysStatement x, OConnection connection) {
    }

    public static void showmasterstatus(MySqlShowMasterStatusStatement x, OConnection connection) {
    }

    public static void showopentable(MySqlShowOpenTablesStatement x, OConnection connection) {
    }

    public static void showplugins(MySqlShowPluginsStatement x, OConnection connection) {
    }

    public static void showprivileges(MySqlShowPrivilegesStatement x, OConnection connection) {
    }

    public static void showprovedureode(MySqlShowProcedureCodeStatement x, OConnection connection) {
    }

    public static void showproedurestatus(MySqlShowProcedureStatusStatement x, OConnection connection) {
    }

    public static void showprocesslist(MySqlShowProcessListStatement x, OConnection connection) {
    }

    public static void showprofile(MySqlShowProfileStatement x, OConnection connection) {
    }

    public static void showprofiles(MySqlShowProfilesStatement x, OConnection connection) {
    }

    public static void showrelaylog(MySqlShowRelayLogEventsStatement x, OConnection connection) {
    }

    public static void showslavehosts(MySqlShowSlaveHostsStatement x, OConnection connection) {
    }

    public static void showslavestatus(MySqlShowSlaveStatusStatement x, OConnection connection) {
    }

    public static void showtablestatus(MySqlShowTableStatusStatement x, OConnection connection) {
    }

    public static void showtriggers(MySqlShowTriggersStatement x, OConnection connection) {
    }

    public static void showvatiants(MySqlShowVariantsStatement x, OConnection connection) {
        ShowVariables.response(connection);
    }

    public static void showtables(SQLShowTablesStatement x, OConnection connection) {
        ShowTables.response(connection, x.toString(), 0);
    }
}