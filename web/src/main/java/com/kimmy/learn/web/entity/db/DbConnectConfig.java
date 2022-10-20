package com.kimmy.learn.web.entity.db;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class DbConnectConfig {

    // 主键
    private int id;
    // 数据库类型
    private String dbType;
    // 数据库昵称
    private String nickName;
    // 连接库IP
    private String dbIp;
    // 数据库连接端口
    private int dbPort;
    // 默认链接库
    private String defaultConnectDb;
    // 驱动类名
    private String driverClassName;
    // 登录用户名
    private String dbUser;
    // 登录用户密码
    private String dbPwd;
    // 数据状态 0:禁用 1:正常
    private int status;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDbIp() {
        return dbIp;
    }

    public void setDbIp(String dbIp) {
        this.dbIp = dbIp;
    }

    public int getDbPort() {
        return dbPort;
    }

    public void setDbPort(int dbPort) {
        this.dbPort = dbPort;
    }

    public String getDefaultConnectDb() {
        return defaultConnectDb;
    }

    public void setDefaultConnectDb(String defaultConnectDb) {
        this.defaultConnectDb = defaultConnectDb;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPwd() {
        return dbPwd;
    }

    public void setDbPwd(String dbPwd) {
        this.dbPwd = dbPwd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
