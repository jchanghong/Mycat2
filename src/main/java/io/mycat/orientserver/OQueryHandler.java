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
package io.mycat.orientserver;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlASTVisitor;
import io.mycat.config.ErrorCode;
import io.mycat.net.handler.FrontendQueryHandler;
import io.mycat.orientserver.handler.data_define.AlterServer;
import io.mycat.orientserver.handler.data_define.DropEVENT;
import io.mycat.orientserver.handler.data_define.DropView;
import io.mycat.orientserver.parser.MSQLvisitor;
import io.mycat.orientserver.response.ShowTables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author 服务器查询处理器
 */
public class OQueryHandler implements FrontendQueryHandler {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(OQueryHandler.class);

    private final OConnection source;
    protected Boolean readOnly;
    private MySqlASTVisitor mySqlASTVisitor;

    public OQueryHandler(OConnection source) {
        this.source = source;
        mySqlASTVisitor = new MSQLvisitor(source);
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    private Exception exception;
    @Override
    public void query(String sql) {
        OConnection c = this.source;
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(new StringBuilder().append(c).append(sql).toString());
        }
        List<SQLStatement> lists;
        try {
            MySqlStatementParser parser = new MySqlStatementParser(sql);
            lists = parser.parseStatementList();
            lists.forEach(statement -> statement.accept(mySqlASTVisitor));
            if (lists != null&&lists.size()>0) {
                exception = null;
                return;
            }
        } catch (Exception e) {//如果不是合法的mysql语句，就报错
//            e.printStackTrace();
            exception = e;
//            return;
        }
        //druid支持的语句就用上面的方法语句处理，如果不支持，就会有异常，就自己写代码解析sql语句，处理。
        //下面是drop event语句的例子，这个例子druid不支持，所以自己写
        handleotherStatement(sql, c);
    }

    private void handleotherStatement(String sql, OConnection c) {
        if (DropEVENT.isdropevent(sql)) {//判断是不是dropevent语句
            DropEVENT.handle(sql,c);
            return;
        }
        if (AlterServer.ismy(sql)) {
            AlterServer.handle(sql, c);
            return;
        }
        c.writeErrMessage(ErrorCode.ER_SP_BAD_SQLSTATE, exception == null ? "不支持的语句！！！" : exception.getMessage());
    }
}

