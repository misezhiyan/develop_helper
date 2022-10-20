package com.kimmy.learn.web.controller.domain.request;

import org.springframework.stereotype.Component;

@Component
public class ConnectRequest {

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
}
