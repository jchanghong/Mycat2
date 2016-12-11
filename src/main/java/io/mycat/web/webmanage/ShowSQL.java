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
package io.mycat.web.webmanage;

import io.mycat.backend.mysql.PacketUtil;
import io.mycat.config.Fields;
import io.mycat.manager.ManagerConnection;
import io.mycat.net.mysql.EOFPacket;
import io.mycat.net.mysql.FieldPacket;
import io.mycat.net.mysql.ResultSetHeaderPacket;
import io.mycat.net.mysql.RowDataPacket;
import io.mycat.statistic.stat.UserSqlLastStat;
import io.mycat.statistic.stat.UserStat;
import io.mycat.statistic.stat.UserStatAnalyzer;
import io.mycat.util.LongUtil;
import io.mycat.util.StringUtil;
import io.mycat.web.model.ReturnMessage;
import io.mycat.web.model.UserSQLRecot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 查询用户最近执行的SQL记录
 * 
 * @author mycat
 * @author zhuam
 * @author changhong
 */
@RestController
@SuppressWarnings({"UnusedAssignment", "Duplicates"})
public final class ShowSQL {


    /**
     * 查询用户最近执行的SQL记录
     *
     * @author changhong
     */
    @GetMapping("/getuserlastsqls")
    public ReturnMessage execute(/*ManagerConnection c, boolean isClear*/) {
        ReturnMessage returnMessage = new ReturnMessage();
        List<UserSQLRecot> list = new ArrayList<>();
        Map<String, UserStat> statMap = UserStatAnalyzer.getInstance().getUserStatMap();
        for (UserStat userStat : statMap.values()) {
            String user = userStat.getUser();
            List<UserSqlLastStat.SqlLast> sqls = userStat.getSqlLastStat().getSqls();
            for (UserSqlLastStat.SqlLast sqlLast : sqls) {
                if (sqlLast != null) {
                    list.add(new UserSQLRecot(user, sqlLast));
                }
            }
        }
        returnMessage.setError(false);
        returnMessage.setObject(list.toArray());
        return returnMessage;
    }
}