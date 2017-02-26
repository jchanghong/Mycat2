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

    public static void showwarnings(MySqlShowWarningsStatement x) {
    }

    public static void showstatus(MySqlShowStatusStatement x) {
    }

    public static void showauthors(MySqlShowAuthorsStatement x) {
    }

    public static void showbinarylogs(MySqlShowBinaryLogsStatement x) {
    }

    public static void showmasterlogs(MySqlShowMasterLogsStatement x) {
    }

    public static void showcollation(MySqlShowCollationStatement x) {
    }

    public static void showbinlogevent(MySqlShowBinLogEventsStatement x) {
    }

    public static void showcharater(MySqlShowCharacterSetStatement x) {
    }

    public static void showcontributors(MySqlShowContributorsStatement x) {
    }

    public static void showcreatedatabase(MySqlShowCreateDatabaseStatement x) {
    }

    public static void showcreateevent(MySqlShowCreateEventStatement x) {
    }

    public static void showcreatefunction(MySqlShowCreateFunctionStatement x) {
    }

    public static void showcreateproccedure(MySqlShowCreateProcedureStatement x) {
    }

    public static void showcreatetable(MySqlShowCreateTableStatement x) {
    }

    public static void showcreatetrigger(MySqlShowCreateTriggerStatement x) {
    }

    public static void showcreateview(MySqlShowCreateViewStatement x) {
    }

    public static void showengine(MySqlShowEngineStatement x) {
    }

    public static void showengines(MySqlShowEnginesStatement x) {
    }

    public static void showerrors(MySqlShowErrorsStatement x) {
    }

    public static void showevents(MySqlShowEventsStatement x) {
    }

    public static void showfunctioncode(MySqlShowFunctionCodeStatement x) {
    }

    public static void showfunctionstatus(MySqlShowFunctionStatusStatement x) {
    }

    public static void showgrants(MySqlShowGrantsStatement x) {
    }

    public static void showindexs(MySqlShowIndexesStatement x) {
    }

    public static void showkeys(MySqlShowKeysStatement x) {
    }

    public static void showmasterstatus(MySqlShowMasterStatusStatement x) {
    }

    public static void showopentable(MySqlShowOpenTablesStatement x) {
    }

    public static void showplugins(MySqlShowPluginsStatement x) {
    }

    public static void showprivileges(MySqlShowPrivilegesStatement x) {
    }

    public static void showprovedureode(MySqlShowProcedureCodeStatement x) {
    }

    public static void showproedurestatus(MySqlShowProcedureStatusStatement x) {
    }

    public static void showprocesslist(MySqlShowProcessListStatement x) {
    }

    public static void showprofile(MySqlShowProfileStatement x) {
    }

    public static void showprofiles(MySqlShowProfilesStatement x) {
    }

    public static void showrelaylog(MySqlShowRelayLogEventsStatement x) {
    }

    public static void showslavehosts(MySqlShowSlaveHostsStatement x) {
    }

    public static void showslavestatus(MySqlShowSlaveStatusStatement x) {
    }

    public static void showtablestatus(MySqlShowTableStatusStatement x) {
    }

    public static void showtriggers(MySqlShowTriggersStatement x) {
    }

    public static void showvatiants(MySqlShowVariantsStatement x) {
    }

    public static void showtables(SQLShowTablesStatement x, OConnection connection) {
        ShowTables.response(connection, x.toString(), 0);
    }
}