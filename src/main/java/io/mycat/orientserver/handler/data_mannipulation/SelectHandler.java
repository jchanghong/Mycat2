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
import com.alibaba.druid.sql.ast.expr.SQLBinaryOperator;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import io.mycat.orientserver.OConnection;
import io.mycat.orientserver.handler.DefaultHander;
import io.mycat.orientserver.response.*;
import io.mycat.orientserver.util.Mcomputer;

import java.util.Arrays;

/**
 * @author changhong
 * select 语句有些是selct table，
 * 有些比如是select suer（）；
 */
public final class SelectHandler {

    public static void handle(SQLSelectStatement selectStatement, OConnection c) {

        MySqlSelectQueryBlock queryBlock = (MySqlSelectQueryBlock) selectStatement.getSelect().getQuery();
        if (queryBlock.getFrom() != null) {
            DefaultHander.handlequery(selectStatement, c);// select 数据
            return;
        }
        SQLSelectItem selectItem = queryBlock.getSelectList().get(0);
        if (selectItem.getExpr() instanceof SQLBinaryOpExpr) {
            handleopexpr((SQLBinaryOpExpr) selectItem.getExpr(),c);
            return;
        }
        SQLExpr sqlExpr = selectItem.getExpr();
        String what = sqlExpr.toString().toUpperCase();
        if (what.startsWith("VERSION_COMMENT")) {
            io.mycat.orientserver.response.SelectVersionComment.response(c);
            return;
        }
        if (what.startsWith("DATABASE")) {
            SelectDatabase.response(c);
            return;
        }
        if (what.startsWith("USER")) {
            SelectUser.response(c);
            return;
        }
        if (what.startsWith("VERSION")) {
            SelectVersion.response(c);
            return;
        }
        if (what.startsWith("SESSION_INCREMENT")) {
            SessionIncrement.response(c);
            return;
        }
        if (what.startsWith("SESSION_ISOLATION")) {
            SessionIsolation.response(c);
            return;
        }
        if (what.startsWith("LAST_INSERT_ID")) {
                SelectLastInsertId.response(c, selectStatement.toString(), 1);
                return;
        }
        if (what.startsWith("IDENTITY")) {
                SelectIdentity.response(c, selectStatement.toString(), 1, "mysql");
                return;
        }
        if (what.startsWith("SELECT_VAR_ALL")) {
            ShowVariables.response(c);
            return;

        }
        if (what.startsWith("SESSION_TX_READ_ONLY")) {
            SelectTxReadOnly.response(c);
            return;
        }
    }

    private static void handleopexpr(SQLBinaryOpExpr sqlBinaryOpExpr,OConnection connection) {
        String columnname = sqlBinaryOpExpr.toString();
        Select1Response.response(connection, columnname, Arrays.asList(Mcomputer.compute(columnname)+""));

    }
}
