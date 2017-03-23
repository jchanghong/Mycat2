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
package io.mycat.orientserver.handler.data_mannipulation;

import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.expr.SQLBinaryOpExpr;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import com.orientechnologies.orient.core.record.impl.ODocument;
import io.mycat.databaseorient.adapter.MDBadapter;
import io.mycat.databaseorient.adapter.MException;
import io.mycat.databaseorient.constant.Minformation_schama;
import io.mycat.databaseorient.constant.MvariableTable;
import io.mycat.orientserver.OConnection;
import io.mycat.orientserver.response.*;
import io.mycat.orientserver.util.Mcomputer;

import java.util.Arrays;
import java.util.List;

/**
 * @author changhong
 * select 语句有些是selct table from,,,,,，
 * select 6+1;
 * select dabase();
 * 有些比如是select suer（）；
 */
public final class MSelectHandler {

    public static void handle(SQLSelectStatement selectStatement, OConnection c) {

        MySqlSelectQueryBlock queryBlock = (MySqlSelectQueryBlock) selectStatement.getSelect().getQuery();
        if (queryBlock.getFrom() != null) {
            MorientSelectResponse.responseselect(c, selectStatement.toString(),selectStatement);
            return;
        }
        SQLSelectItem selectItem = queryBlock.getSelectList().get(0);
        boolean number = true;
        try {
            Double.parseDouble(selectItem.toString());
        } catch (Exception e) {
//            e.printStackTrace();
            number = false;
        }
        if (number) {
            Select1Response.response(c, selectItem.toString(), Arrays.asList(selectItem.toString()));
            return;
        }
        if (selectItem.getExpr() instanceof SQLBinaryOpExpr) {
            handleopexpr((SQLBinaryOpExpr) selectItem.getExpr(),c);
            return;
        }

        SQLExpr sqlExpr = selectItem.getExpr();
        if (selectStatement.toString().contains("@") && selectStatement.toString().contains("AS")) {
            List<String> column = MselectVariables.getcolumn(selectStatement);
            List<String> value = MselectVariables.getbs(selectStatement,column);
            MselectNResponse.response(c, column, value);
            return;
        }
        String what = sqlExpr.toString().toUpperCase();
        if (what.contains("VERSION_COMMENT")) {
            io.mycat.orientserver.response.SelectVersionComment.response(c);
            return;
        }
        if (what.contains("DATABASE")) {
            SelectDatabase.response(c);
            return;
        }
        if (what.contains("CONNECTION_ID")) {
            SelectConnnectID.response(c);
            return;
        }
        if (what.contains("USER")) {
            SelectUser.response(c);
            return;
        }
        if (what.contains("VERSION")) {
            SelectVersion.response(c);
            return;
        }
        //SESSION_INCREMENT
        if (what.contains("INCREMENT")) {
            SessionIncrement.response(c);
            return;
        }
        //SESSION_ISOLATION
        if (what.contains("ISOLATION")) {
            SessionIsolation.response(c);
            return;
        }
        if (what.contains("LAST_INSERT_ID")) {
                SelectLastInsertId.response(c, selectStatement.toString(), 1);
                return;
        }
        if (what.contains("IDENTITY")) {
                SelectIdentity.response(c, selectStatement.toString(), 1, "mysql");
                return;
        }
        if (what.contains("SELECT_VAR_ALL")) {
            ShowVariables.response(c);
            return;

        }
        //SESSION_TX_READ_ONLY
        if (what.contains("TX_READ_ONLY")) {
            SelectTxReadOnly.response(c);
            return;
        }
        what = sqlExpr.toString();
        if (what.contains("@@")) {
            int index = what.indexOf(".");
            if (index != -1) {
                what = what.substring(index + 1);
                what = "select value from " + MvariableTable.tablename + "  where Variable_name='" + what + "';";
                try {
                    List<ODocument> documents = MDBadapter.exequery(what, Minformation_schama.dbname);
                    Select1Response.response(c,what,Arrays.asList(documents.get(0).field("value")));
                    return;
                } catch (MException e) {
                    e.printStackTrace();
                    c.writeErrMessage(e.getMessage());
                    return;
                }
            }
        }
        c.writeNotSurrport();
    }

    private static void handleopexpr(SQLBinaryOpExpr sqlBinaryOpExpr,OConnection connection) {
        String columnname = sqlBinaryOpExpr.toString();
        Select1Response.response(connection, columnname, Arrays.asList(Mcomputer.compute(columnname)+""));

    }
}
