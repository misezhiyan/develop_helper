package com.kimmy.learn.web.test;

import com.alibaba.druid.DbType;
import com.alibaba.fastjson.JSON;
import com.kimmy.learn.web.controller.domain.response.ConnectResponse;
import com.kimmy.learn.web.db.connect.DynamicDbManager;
import com.kimmy.learn.web.db.connect.DynamicDbRunner;
import com.kimmy.learn.web.entity.db.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    DynamicDbManager dynamicDbManager;

    public ConnectResponse testDbConnect() {

        ConnectResponse response = new ConnectResponse();

        // // mysql 连接
        // DruidDataSource mysqlDataSource = new DruidDataSource();
        // mysqlDataSource.setDbType(DbType.mysql);
        // mysqlDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        // mysqlDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        // mysqlDataSource.setUsername("root");
        // mysqlDataSource.setPassword("root");
        //
        // try {
        //
        //     DruidPooledConnection connection = mysqlDataSource.getConnection();
        //
        //     // DynamicDbManager.connection()
        //
        //     String sql = "select * from dataease.datasource";
        //     sql = "select * from test.test";
        //     PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //     ResultSet resultSet = preparedStatement.executeQuery();
        //
        //     while (resultSet.next()) {
        //         System.out.print(resultSet.getString("id"));
        //         System.out.println(resultSet.getString("test"));
        //     }
        //
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        DynamicDbRunner runner = dynamicDbManager.getRunner(1, DbType.mysql, "com.mysql.cj.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/test", "root", "root");
        String sql = "select * from test.test";
        // List<Test> list = runner.queryList(sql, Test.class);

        List<Test> list = runner.queryList(sql, Test.class);
        System.out.println(JSON.toJSONString(list));

        return response;
    }
}
