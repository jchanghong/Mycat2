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
import io.mycat.util.TimeUtil;
import io.mycat.web.model.ReturnMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务器状态报告
 *
 * @author mycat
 * @author mycat
 * @author changhong
 */
@SuppressWarnings("Duplicates")
@RestController
public final class ShowServer {
    @GetMapping("/getserverstatus")
    public ReturnMessage execute() {
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setObject(getmaps());
        return returnMessage;
    }

    private static Map<String, String> getmaps() {
        Map<String, String> map = new HashMap<>();
        MycatServer server = MycatServer.getInstance();
        long startupTime = server.getStartupTime();
        map.put("startupTime", String.valueOf(startupTime));
        long now = TimeUtil.currentTimeMillis();
        long uptime = now - startupTime;
        map.put("uptime", String.valueOf(uptime));
        Runtime rt = Runtime.getRuntime();
        long total = rt.totalMemory();
        long max = rt.maxMemory();
        long used = (total - rt.freeMemory());
        map.put("total", total + "");
        map.put("max", max + "");
        map.put("used", used + "");
        return map;
    }

}