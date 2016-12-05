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

import io.mycat.MycatServer;
import io.mycat.backend.datasource.PhysicalDBPool;
import io.mycat.backend.datasource.PhysicalDatasource;
import io.mycat.backend.heartbeat.DBHeartbeat;
import io.mycat.backend.mysql.PacketUtil;
import io.mycat.config.Fields;
import io.mycat.config.MycatConfig;
import io.mycat.manager.ManagerConnection;
import io.mycat.net.mysql.EOFPacket;
import io.mycat.net.mysql.FieldPacket;
import io.mycat.net.mysql.ResultSetHeaderPacket;
import io.mycat.net.mysql.RowDataPacket;
import io.mycat.util.IntegerUtil;
import io.mycat.util.LongUtil;
import io.mycat.web.model.ReturnMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.ByteBuffer;
import java.util.*;

/**
 * @author changhong
 * 心跳状态，也就是服务器是不是死机了等等
 */
@SuppressWarnings("Duplicates")
@RestController
public class ShowHeartbeat {

    /**
     * @author changhong
     * 得到心跳状态，也就是服务器是不是死机了等等
     */
    @GetMapping("/getheartbeatstatus")
    public ReturnMessage response() {
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setObject(getRows());
        return returnMessage;
    }
    private static List<Map<String, String>> getRows() {
        List<Map<String, String>> maps = new ArrayList<>();
        MycatConfig conf = MycatServer.config;
        // host nodes
        Map<String, PhysicalDBPool> dataHosts = conf.getDataHosts();
        for (PhysicalDBPool pool : dataHosts.values()) {
            for (PhysicalDatasource ds : pool.getAllDataSources()) {
                Map<String, String> map = new HashMap<>();
                DBHeartbeat hb = ds.getHeartbeat();
                map.put("name", ds.getName());
                map.put("type", ds.getConfig().getDbType());
                if (hb != null) {
                    map.put("port", ds.getConfig().getPort() + "");
                    map.put("ip", ds.getConfig().getIp());
//					map.put("status", hb.getStatus() + "");
                    map.put("errorcount", hb.getErrorCount() + "");
                    map.put("timeout", hb.getTimeout() + "");
                    map.put("status", hb.isChecking() ? "checking" : "idle");
                    String lat = hb.getLastActiveTime();
                    map.put("lasttime", lat);
                    map.put("stop", (hb.isStop() ? "true" : "false"));
                } else {
                    map.put("port", null);
                    map.put("ip", null);
//					map.put("status", hb.getStatus() + "");
                    map.put("errorcount", null);
                    map.put("timeout", null);
                    map.put("status", null);
                    String lat = hb.getLastActiveTime();
                    map.put("lasttime", null);
                    map.put("stop", null);
                }
                maps.add(map);
            }
        }
        return maps;
    }

}