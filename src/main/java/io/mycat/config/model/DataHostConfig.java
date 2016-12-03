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
package io.mycat.config.model;

import com.google.common.collect.Iterables;
import io.mycat.backend.datasource.PhysicalDBPool;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Datahost is a group of DB servers which is synchronized with each other
 *
 * @author wuzhih
 * @author changhong
 *代表一个主机群，属性不要final
 */
@SuppressWarnings("Duplicates")
public class DataHostConfig implements Serializable{
	private static  long serialVersionUID = -6605226933829917213L;
	public static  int NOT_SWITCH_DS = -1;
	public static  int DEFAULT_SWITCH_DS = 1;
	public static  int SYN_STATUS_SWITCH_DS = 2;
	public static  int CLUSTER_STATUS_SWITCH_DS = 3;
    private static  Pattern pattern = Pattern.compile("\\s*show\\s+slave\\s+status\\s*",Pattern.CASE_INSENSITIVE);
    private static  Pattern patternCluster = Pattern.compile("\\s*show\\s+status\\s+like\\s+'wsrep%'",Pattern.CASE_INSENSITIVE);
    @NotNull
    private String hearbeatSQL;
    @NotNull
	private String name;
    @NotNull
    private  String dbType="mysql";//不能为空，但是可以不设置，默认为mysql
    @NotNull
    private  String dbDriver="native";
    @NotNull
    private  int switchType=0;
    private int maxCon = SystemConfig.DEFAULT_POOL_SIZE;
    private int minCon = 10;
    private int balance = PhysicalDBPool.BALANCE_NONE;
    private int writeType = PhysicalDBPool.WRITE_ONLYONE_NODE;
    private  DBHostConfig[] writeHosts;
    private  Map<Integer, DBHostConfig[]> readHosts;
    private boolean isShowSlaveSql=false;
    private boolean isShowClusterSql=false;
    private String connectionInitSql;
    private int slaveThreshold = -1;//?
	private String filters="mergeStat";
	private long logTime=300000;
	private boolean tempReadHostAvailable = false;  //如果写服务挂掉, 临时读服务是否继续可用
	private  Set<String> dataNodes; //包含的所有dataNode名字
	private String slaveIDs;//?

    /**
     * Addwhost 增加一个写主机
     * @author changhong
     * @param dbHostConfig the db host config
     */
    public void addwhost(DBHostConfig dbHostConfig) {
        if (this.writeHosts == null) {
            this.writeHosts = new DBHostConfig[1];
            writeHosts[0] = dbHostConfig;

        }
        else {
            DBHostConfig[] temp = new DBHostConfig[writeHosts.length + 1];
            for (int i = 0; i < temp.length-1; i++) {
                temp[i] = writeHosts[i];
            }
            temp[temp.length - 1] = dbHostConfig;
            writeHosts = temp;
        }
    }
    /**
     * Addwhost remove一个主机
     * @author changhong
     * @param dbHostConfig the db host config
     */
    public void removehost(String name) {
        List<DBHostConfig> list = Arrays.asList(writeHosts);
        Optional<DBHostConfig> dbHostConfig = list.stream().filter(a -> a.getHostName().equals(name)).findAny();
        if (dbHostConfig.isPresent()) {
            list.remove(dbHostConfig.get());
        }
    }

    /**
     * Addrhost.增加一个从机。读机
     *
     * @param writename    the writename主机的名字
     * @param dbHostConfig the db host config
     */
    public void addrhost(String writename, DBHostConfig dbHostConfig) {
        int index = 0;
        for (int i = 0; i < writeHosts.length; i++) {
            DBHostConfig writeHost = writeHosts[i];
            if (writeHost.getHostName().equals(writename)) {
                index = i;
            }
        }
        DBHostConfig[] hostConfigs = readHosts.get(index);
        if (hostConfigs == null) {
            hostConfigs = new DBHostConfig[1];
            hostConfigs[0] = dbHostConfig;
            readHosts.put(index, hostConfigs);
        }
        else {
            DBHostConfig[] temp = new DBHostConfig[hostConfigs.length + 1];
            for (int i = 0; i < temp.length-1; i++) {
                temp[i] = hostConfigs[i];
            }
            temp[temp.length - 1] = dbHostConfig;
            hostConfigs = temp;
            readHosts.put(index, hostConfigs);
        }
    }
    /**
     * Addrhost.&#x589e;&#x52a0;&#x4e00;&#x4e2a;&#x4ece;&#x673a;&#x3002;&#x8bfb;&#x673a;
     *
     * @param index    the writename&#x4e3b;&#x673a;&#x7684;index
     * @param dbHostConfig the db host config
     */
    public void addrhost(int index, DBHostConfig dbHostConfig) {
        DBHostConfig[] hostConfigs = readHosts.get(index);
        if (hostConfigs == null) {
            hostConfigs = new DBHostConfig[1];
            hostConfigs[0] = dbHostConfig;
            readHosts.put(index, hostConfigs);
        }
        else {
            DBHostConfig[] temp = new DBHostConfig[hostConfigs.length + 1];
            for (int i = 0; i < temp.length-1; i++) {
                temp[i] = hostConfigs[i];
            }
            temp[temp.length - 1] = dbHostConfig;
            hostConfigs = temp;
            readHosts.put(index, hostConfigs);
        }
    }
    /**
     * Instantiates a new Data host config.
     * @auther changhong
     *
     */
    public DataHostConfig() {
        this.dataNodes = new HashSet<>();
        readHosts = new HashMap<>();
    }

    public DataHostConfig(String name, String dbType, String dbDriver,
                          DBHostConfig[] writeHosts, Map<Integer, DBHostConfig[]> readHosts, int switchType, int slaveThreshold, boolean tempReadHostAvailable) {
		super();
		this.name = name;
		this.dbType = dbType;
		this.dbDriver = dbDriver;
		this.writeHosts = writeHosts;
		this.readHosts = readHosts;
		this.switchType=switchType;
		this.slaveThreshold=slaveThreshold;
		this.tempReadHostAvailable = tempReadHostAvailable;
		this.dataNodes = new HashSet<>();
	}

	public boolean isTempReadHostAvailable() {
		return this.tempReadHostAvailable;
	}

	public int getSlaveThreshold() {
		return slaveThreshold;
	}

	public void setSlaveThreshold(int slaveThreshold) {
		this.slaveThreshold = slaveThreshold;
	}

	public int getSwitchType() {
		return switchType;
	}

	public String getConnectionInitSql()
	{
		return connectionInitSql;
	}

	public void setConnectionInitSql(String connectionInitSql)
	{
		this.connectionInitSql = connectionInitSql;
	}

	public int getWriteType() {
		return writeType;
	}

	public void setWriteType(int writeType) {
		this.writeType = writeType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public boolean isShowSlaveSql()
    {
        return isShowSlaveSql;
    }

    public int getMaxCon() {
		return maxCon;
	}

	public void setMaxCon(int maxCon) {
		this.maxCon = maxCon;
	}

	public int getMinCon() {
		return minCon;
	}

	public void setMinCon(int minCon) {
		this.minCon = minCon;
	}

	public String getSlaveIDs() {
		return slaveIDs;
	}

	public void setSlaveIDs(String slaveIDs) {
		this.slaveIDs = slaveIDs;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getDbType() {
		return dbType;
	}

	public String getDbDriver() {
		return dbDriver;
	}

	public DBHostConfig[] getWriteHosts() {
		return writeHosts;
	}

	public Map<Integer, DBHostConfig[]> getReadHosts() {
		return readHosts;
	}

	public String getHearbeatSQL() {
		return hearbeatSQL;
	}

	public void setHearbeatSQL(String heartbeatSQL) {
		this.hearbeatSQL = heartbeatSQL;
        Matcher matcher = pattern.matcher(heartbeatSQL);
        if (matcher.find())
        {
            isShowSlaveSql=true;
        }
        Matcher matcher2 = patternCluster.matcher(heartbeatSQL);
        if (matcher2.find())
        {
        	isShowClusterSql=true;
        }
	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public long getLogTime() {
		return logTime;
	}

	public boolean isShowClusterSql() {
		return this.isShowClusterSql;
	}

	public void setLogTime(long logTime) {
		this.logTime = logTime;
	}

	public void addDataNode(String name){
		this.dataNodes.add(name);
	}

	public String getRandomDataNode() {
		int index = (int) (Math.random() * dataNodes.size());
		return Iterables.get(dataNodes,index);
	}

	public void setShowSlaveSql(boolean showSlaveSql) {
		isShowSlaveSql = showSlaveSql;
	}

	public void setShowClusterSql(boolean showClusterSql) {
		isShowClusterSql = showClusterSql;
	}

	public void setTempReadHostAvailable(boolean tempReadHostAvailable) {
		this.tempReadHostAvailable = tempReadHostAvailable;
	}

	public Set<String> getDataNodes() {
		return dataNodes;
	}

	public boolean containDataNode(String randomDn) {
        return dataNodes.contains(randomDn);
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public void setWriteHosts(DBHostConfig[] writeHosts) {
        this.writeHosts = writeHosts;
    }

    public void setReadHosts(Map<Integer, DBHostConfig[]> readHosts) {
        this.readHosts = readHosts;
    }

    public void setSwitchType(int switchType) {
        this.switchType = switchType;
    }

    public void setDataNodes(Set<String> dataNodes) {
        this.dataNodes = dataNodes;
    }
}