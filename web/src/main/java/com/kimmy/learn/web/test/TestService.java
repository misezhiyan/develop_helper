package com.kimmy.learn.web.test;

import com.alibaba.druid.DbType;
import com.alibaba.fastjson.JSON;
import com.kimmy.learn.web.controller.domain.response.ConnectResponse;
import com.kimmy.learn.web.db.connect.DynamicDbManager;
import com.kimmy.learn.web.db.connect.DynamicDbRunner;
import com.kimmy.learn.web.entity.db.Test;
import com.kimmy.learn.web.entity.domains.db.Column;
import com.kimmy.learn.web.entity.domains.db.Table;
import com.kimmy.learn.web.entity.domains.db.TablePack;
import com.kimmy.learn.web.entity.domains.template.TemplateParams;
import com.kimmy.learn.web.mapper.DbMapper;
import com.kimmy.learn.web.template.TemplateMatcher;
import com.kimmy.learn.web.template.freemarker.FreeMarkerMatcher;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TestService {

    @Autowired
    DynamicDbManager dynamicDbManager;
    @Autowired
    DbMapper dbMapper;

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

    public void testFreemarker() throws IOException, TemplateException {

        TemplateMatcher templateMatcher = new FreeMarkerMatcher();

        String tempname = "test";
        String content = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" + "<!DOCTYPE mapper\n" + "        PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\"\n" + "        \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n" + "<mapper namespace=\"${table.className}Mapper\">\n" + "\n" + "    <resultMap id=\"BaseResultMap\" type=\"${table.className}\">\n" + "\t\t<#list table.columnList as column>\n" + "\t\t\t<#if column.primary>\n" + "        <id column=\"${column.columnName}\" property=\"${column.className}\" jdbcType=\"${column.jdbcType}\"/>\n" + "\t\t\t<#else>\n" + "        <result column=\"${column.columnName}\" property=\"${column.className}\" jdbcType=\"${column.jdbcType}\"/>\n" + "\t\t\t</#if>\n" + "\t\t</#list>\n" + "    </resultMap>\n" + "\n" + "    <sql id=\"BaseColumns\">\n" + "\t\t<#list table.columnList as column>\n" + "        ${column.columnName}<#if column_has_next>,</#if>\n" + "\t\t</#list>\n" + "    </sql>\n" + "\n" + "</mapper>";
        TemplateParams params = new TemplateParams();

        TablePack table = dbMapper.tableDetail("template");
        params.asParam("table", table);
        System.out.println(JSON.toJSONString(params));

        String result = templateMatcher.matchStrToStr(tempname, content, params);

        System.out.println(result);
    }
}
