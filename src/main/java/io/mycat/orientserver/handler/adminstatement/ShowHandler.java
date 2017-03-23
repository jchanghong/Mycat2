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
import io.mycat.databaseorient.constant.Mconstantvariables;
import io.mycat.databaseorient.constant.MvariableTable;
import io.mycat.orientserver.OConnection;
import io.mycat.orientserver.handler.data_mannipulation.MselectVariables;
import io.mycat.orientserver.response.*;

import java.util.ArrayList;

/**
 * @author changhong show开头的语句
 */
public final class ShowHandler {

    public static void showcolumn(MySqlShowColumnsStatement x,OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showdatabase(MySqlShowDatabasesStatement x, OConnection c) {
        ShowDatabases.response(c);
    }

    public static void showwarnings(MySqlShowWarningsStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());

    }

    // SHOW SESSION STATUS LIKE 'Ssl_cipher';
    public static void showstatus(MySqlShowStatusStatement x, OConnection connection) {
        String likes = x.getLike().toString();
        Select1Response.response(connection, likes, new ArrayList<>());

    }

    public static void showauthors(MySqlShowAuthorsStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showbinarylogs(MySqlShowBinaryLogsStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showmasterlogs(MySqlShowMasterLogsStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showcollation(MySqlShowCollationStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showbinlogevent(MySqlShowBinLogEventsStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showcharater(MySqlShowCharacterSetStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showcontributors(MySqlShowContributorsStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showcreatedatabase(MySqlShowCreateDatabaseStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showcreateevent(MySqlShowCreateEventStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showcreatefunction(MySqlShowCreateFunctionStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showcreateproccedure(MySqlShowCreateProcedureStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showcreatetable(MySqlShowCreateTableStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showcreatetrigger(MySqlShowCreateTriggerStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showcreateview(MySqlShowCreateViewStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showengine(MySqlShowEngineStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showengines(MySqlShowEnginesStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showerrors(MySqlShowErrorsStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showevents(MySqlShowEventsStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showfunctioncode(MySqlShowFunctionCodeStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showfunctionstatus(MySqlShowFunctionStatusStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showgrants(MySqlShowGrantsStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showindexs(MySqlShowIndexesStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showkeys(MySqlShowKeysStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showmasterstatus(MySqlShowMasterStatusStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showopentable(MySqlShowOpenTablesStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showplugins(MySqlShowPluginsStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showprivileges(MySqlShowPrivilegesStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showprovedureode(MySqlShowProcedureCodeStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showproedurestatus(MySqlShowProcedureStatusStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showprocesslist(MySqlShowProcessListStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showprofile(MySqlShowProfileStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showprofiles(MySqlShowProfilesStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showrelaylog(MySqlShowRelayLogEventsStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showslavehosts(MySqlShowSlaveHostsStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showslavestatus(MySqlShowSlaveStatusStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showtablestatus(MySqlShowTableStatusStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    public static void showtriggers(MySqlShowTriggersStatement x, OConnection connection) {
        Select1Response.response(connection, "no", new ArrayList<>());
    }

    //SHOW VARIABLES WHERE Variable_name ='language' OR
    // Variable_name = 'net_write_timeout'
    // OR Variable_name = 'interactive_timeout'
    // OR Variable_name = 'wait_timeout'
    // OR Variable_name = 'character_set_client'
    // OR Variable_name = 'character_set_connection'
    // OR Variable_name = 'character_set'
    // OR Variable_name = 'character_set_server'
    // OR Variable_name = 'tx_isolation'
    // OR Variable_name = 'transaction_isolation'
    // OR Variable_name = 'character_set_results'
    // OR Variable_name = 'timezone'
    // OR Variable_name = 'time_zone'
    // OR Variable_name = 'system_time_zone'
    // OR Variable_name = 'lower_case_table_names'
    // OR Variable_name = 'max_allowed_packet'
    // OR Variable_name = 'net_buffer_length'
    // OR Variable_name = 'sql_mode'
    // OR Variable_name = 'query_cache_type'
    // OR Variable_name = 'query_cache_size'
    // OR Variable_name = 'license' OR Variable_name = 'init_connect'
    public static void showvatiants(MySqlShowVariantsStatement x, OConnection connection) {
        String sql = x.toString();
        if (x.getWhere() == null) {
            sql = "select * from " + MvariableTable.tablename;
        }
        else {
            StringBuilder builder = new StringBuilder(sql);
            int index = sql.toLowerCase().indexOf("where");
            sql = "select * from " + MvariableTable.tablename +" "+builder.substring(index);
        }
        MselectVariables.handle(connection, sql);
    }

    public static void showtables(SQLShowTablesStatement x, OConnection connection) {
        ShowTables.response(connection, x.toString(), 0);
    }
}