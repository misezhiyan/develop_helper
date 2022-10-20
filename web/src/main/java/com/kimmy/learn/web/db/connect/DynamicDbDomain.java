package com.kimmy.learn.web.db.connect;

import com.alibaba.druid.DbType;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DynamicDbDomain {

    private DynamicDbConfig dbConfig;

    private DruidDataSource dataSource;
    private DruidPooledConnection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    /**
     * 初始化
     * @param dbType
     * @param driverClassName
     * @param url
     * @param userName
     * @param password
     */
    public void init(DbType dbType, String driverClassName, String url, String userName, String password) {
        dbConfig = new DynamicDbConfig();
        dbConfig.setDbType(dbType);
        dbConfig.setDriverClassName(driverClassName);
        dbConfig.setUrl(url);
        dbConfig.setUserName(userName);
        dbConfig.setPassword(password);
    }

    /**
     * 配置数据源
     * @return
     */
    private DruidDataSource getDataSource() {
        if (null == dataSource)
            if (null == dbConfig)
                throw new RuntimeException("未获取到配置信息");
            else {
                dataSource = new DruidDataSource();
                dataSource.setDbType(dbConfig.getDbType());
                dataSource.setDriverClassName(dbConfig.getDriverClassName());
                dataSource.setUrl(dbConfig.getUrl());
                dataSource.setUsername(dbConfig.getUserName());
                dataSource.setPassword(dbConfig.getPassword());
            }

        return dataSource;
    }

    /**
     * 配置数据源
     * @param dbType
     * @param driverClassName
     * @param url
     * @param userName
     * @param password
     * @return
     */
    public DruidDataSource getDataSource(DbType dbType, String driverClassName, String url, String userName, String password) {
        init(dbType, driverClassName, url, userName, password);
        return getDataSource();
    }

    /**
     * 提取链接
     * @return
     */
    public DruidPooledConnection getConnection() {
        if (null != connection)
            return connection;
        try {
            return getDataSource().getConnection();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    /**
     * 关闭链接，并清理对象
     */
    public void close() {
        if (null != dataSource) {
            closeConnection();
        }
        resultSet = null;
        preparedStatement = null;
        connection = null;
        dataSource = null;
    }

    /**
     * 关闭链接
     */
    private void closeConnection() {
        if (null != resultSet) {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (null != preparedStatement) {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (null != connection) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (null != dataSource) {
            try {
                dataSource.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
