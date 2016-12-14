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
package io.mycat.serverproxy;

import io.mycat.MycatServer;
import io.mycat.backend.BackendConnection;
import io.mycat.backend.datasource.PhysicalDBPool;
import io.mycat.backend.datasource.PhysicalDatasource;
import io.mycat.backend.mysql.nio.MySQLConnection;
import io.mycat.server.ServerConnection;

import java.io.IOException;

/**
 * @author mycat
 */
public class Getconhander extends ResponseHandlerAdapter {
	ServerConnection serverConnection;
	static PhysicalDBPool physicalDBPool = MycatServer.config.getDataHosts().values().stream().findAny().orElse(null);

	public Getconhander(ServerConnection serverConnection) {
		this.serverConnection = serverConnection;
	}

	/**
	 * 已获得有效连接的响应处理
	 *
	 * @param conn
	 */
	@Override
	public void connectionAcquired(BackendConnection conn) {
		super.connectionAcquired(conn);
		MySQLConnection mySQLConnection = (MySQLConnection) conn;
//		boolean onread = (boolean) mySQLConnection.getAttachment();
		serverConnection.mysession.mySQLConnection = mySQLConnection;
		serverConnection.mysession.sendtomysql_queue();
//		System.out.println(mySQLConnection.getAttachment() + "con attaicve");
	}

	/**
	 * 无法获取连接
	 *
	 * @param e
	 * @param conn
	 */
	@Override
	public void connectionError(Throwable e, BackendConnection conn) {
		super.connectionError(e, conn);
	}

	public void getSource(boolean onlyread)  {

		if (onlyread)
		{
			try {
				physicalDBPool.getRWBanlanceCon("db", true, this, onlyread, "changhong");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			PhysicalDatasource writeSource =physicalDBPool.getSource();
			//记录写节点写负载值
			writeSource.setWriteCount();
			try {
				writeSource.getConnection("db",true,this,onlyread);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
