package com.kimmy.learn.web.db.connect;

import com.alibaba.druid.DbType;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.kimmy.learn.web.entity.db.DbConnectConfig;
import com.kimmy.learn.web.enums.DbTypeEnums;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DynamicDbManager {

    // 名称
    private static List<DynamicDbRunner> runnerList = new ArrayList<>();

    /**
     * 功能介绍
     * @return
     */

    // 1.外部调用获取链接
    // 2.外部调用关闭链接
    // 3.外部调用获取查询结果

    // 1.外部调用获取链接
    public static synchronized DynamicDbRunner getRunner(Integer connectionId, DbType dbType, String driverClassName, String url, String userName, String password) {

        DynamicDbRunner dynamicDbRunner = runnerList.stream().filter(runner -> runner.matched(connectionId)).findAny().orElse(null);
        if (null == dynamicDbRunner) {
            dynamicDbRunner = new DynamicDbRunner();
            dynamicDbRunner.init(connectionId, dbType, driverClassName, url, userName, password);
        }

        return dynamicDbRunner;
    }

    public DynamicDbRunner getRunner(DbConnectConfig dbConfig) {
        return getRunner(dbConfig.getId(), DbTypeEnums.matchDbType(dbConfig.getDbType()), dbConfig.getDriverClassName(), "jdbc:mysql://" + dbConfig.getDbIp() + ":" + dbConfig.getDbPort() + "/" + dbConfig.getDefaultConnectDb(), dbConfig.getDbUser(), dbConfig.getDbPwd());
    }
}
