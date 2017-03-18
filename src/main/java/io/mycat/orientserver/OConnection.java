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

import io.mycat.backend.mysql.MySQLMessage;
import io.mycat.config.ErrorCode;
import io.mycat.databaseorient.adapter.DBadapter;
import io.mycat.net.FrontendConnection;
import io.mycat.net.mysql.OkPacket;
import io.mycat.orientserver.response.Heartbeat;
import io.mycat.orientserver.response.Ping;
import io.mycat.util.SplitUtil;
import io.mycat.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.NetworkChannel;

/**
 * @author changhong.基于orientdb的服务器，9999端口连接
 */
public class OConnection extends FrontendConnection {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(OConnection.class);
    private static final long AUTH_TIMEOUT = 30 * 1000L;
    private volatile int txIsolation;
    private volatile boolean autocommit;
    private volatile boolean txInterrupted;
    private volatile String txInterrputMsg = "";
    private long lastInsertId;
    /**
     * 标志是否执行了lock tables语句，并处于lock状态
     */
    private volatile boolean isLocked = false;

    public OConnection(NetworkChannel channel)
            throws IOException {
        super(channel);
        this.txInterrupted = false;
        this.autocommit = true;
    }

    public void writeNotSurrport() {
        writeErrMessage(ErrorCode.ER_NOT_SUPPORTED_YET,"暂时不支持！！！");
    }
    @Override
    public boolean isIdleTimeout() {
        if (isAuthenticated) {
            return super.isIdleTimeout();
        } else {
            return TimeUtil.currentTimeMillis() > Math.max(lastWriteTime,
                    lastReadTime) + AUTH_TIMEOUT;
        }
    }

    public int getTxIsolation() {
        return txIsolation;
    }

    public void setTxIsolation(int txIsolation) {
        this.txIsolation = txIsolation;
    }

    public boolean isAutocommit() {
        return autocommit;
    }

    public void setAutocommit(boolean autocommit) {
        this.autocommit = autocommit;
    }

    public long getLastInsertId() {
        return lastInsertId;
    }

    public void setLastInsertId(long lastInsertId) {
        this.lastInsertId = lastInsertId;
    }

    /**
     * 设置是否需要中断当前事务
     */
    public void setTxInterrupt(String txInterrputMsg) {
        if (!autocommit && !txInterrupted) {
            txInterrupted = true;
            this.txInterrputMsg = txInterrputMsg;
        }
    }

    public boolean isTxInterrupted() {
        return txInterrupted;
    }


    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    @Override
    public void ping() {
        Ping.response(this);
    }

    @Override
    public void heartbeat(byte[] data) {
        Heartbeat.response(this, data);
    }


    /**
     * 提交事务
     */
    public void commit() {
        if (txInterrupted) {
            writeErrMessage(ErrorCode.ER_YES,
                    "Transaction error, need to rollback.");
        } else {
        }
    }

    /**
     * 回滚事务
     */
    public void rollback() {
        // 状态检查
        if (txInterrupted) {
            txInterrupted = false;
        }

        // 执行回滚
//        session.rollback();
    }

    /**
     * 执行lock tables语句方法
     *
     * @param sql
     */
    public void lockTable(String sql) {
        // 事务中不允许执行lock table语句
        if (!autocommit) {
            writeErrMessage(ErrorCode.ER_YES, "can't lock table in transaction!");
            return;
        }
        // 已经执行了lock table且未执行unlock table之前的连接不能再次执行lock table命令
        if (isLocked) {
            writeErrMessage(ErrorCode.ER_YES, "can't lock multi-table");
            return;
        }
//        RouteResultset rrs = routeSQL(sql, ServerParse.LOCK);
//        if (rrs != null) {
//            session.lockTable(rrs);
//        }
    }

    /**
     * 执行unlock tables语句方法
     *
     * @param sql
     */
    public void unLockTable(String sql) {
        sql = sql.replaceAll("\n", " ").replaceAll("\t", " ");
        String[] words = SplitUtil.split(sql, ' ', true);
        if (words.length == 2 && ("table".equalsIgnoreCase(words[1]) || "tables".equalsIgnoreCase(words[1]))) {
            isLocked = false;
//            session.unLockTable(sql);
        } else {
            writeErrMessage(ErrorCode.ER_UNKNOWN_COM_ERROR, "Unknown command");
        }

    }

    @Override
    public void close(String reason) {
        super.close(reason);
        if (getLoadDataInfileHandler() != null) {
            getLoadDataInfileHandler().clear();
        }
    }

    @Override
    public String toString() {
        return "OConnection [id=" + id + ", schema=" + schema + ", host="
                + host + ", user=" + user + ",txIsolation=" + txIsolation
                + ", autocommit=" + autocommit + ", schema=" + schema + "]";
    }

    public void writeok() {
        ByteBuffer buffer = allocate();
        write(writeToBuffer(OkPacket.OK, buffer));
    }

    @Override
    public void initDB(byte[] data) {
//        super.initDB(data);
        MySQLMessage mm = new MySQLMessage(data);
        mm.position(5);
        String db = mm.readString();

        // 检查schema的有效性
        if (!DBadapter.getInstance().getalldbnames().contains(db)) {
            writeErrMessage(ErrorCode.ER_BAD_DB_ERROR, "Unknown database '" + db + "'");
            return;
        }
        this.schema = db;
        DBadapter.currentDB = db;
        write(writeToBuffer(OkPacket.OK, allocate()));

    }

    public void writeErrMessage(String message) {
        writeErrMessage(ErrorCode.ER_BAD_DB_ERROR, message);
    }
}
