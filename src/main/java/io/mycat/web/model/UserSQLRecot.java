package io.mycat.web.model;

import io.mycat.statistic.stat.UserSqlLastStat;

import java.io.Serializable;

/**
 * Created by jiang on 2016/12/4 0004.
 *用户最近的sql执行记录
 * 一个对象一条记录
 */
public class UserSQLRecot  implements Serializable{
    String user;
    private String sql;
    private long executeTime;
    private long startTime;
    private long endTime;

    public UserSQLRecot(String user, UserSqlLastStat.SqlLast last) {
        this.user = user;
        this.endTime = last.getEndTime();
        this.executeTime = last.getExecuteTime();
        this.sql = last.getSql();
        this.startTime = last.getStartTime();
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(long executeTime) {
        this.executeTime = executeTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
