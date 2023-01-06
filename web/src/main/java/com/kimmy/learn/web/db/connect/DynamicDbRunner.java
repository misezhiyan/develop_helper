package com.kimmy.learn.web.db.connect;

import com.alibaba.druid.DbType;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.kimmy.learn.web.db.connect.runner.DbColumMatch;
import com.kimmy.learn.web.util.SqlUtils;
import com.kimmy.learn.web.util.StringUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 执行器
 */
@Component
public class DynamicDbRunner {

    // 链接唯一标识
    private Integer connectionId;

    // 链接实体
    private DynamicDbDomain dynamicDbDomain;
    // 数据源
    private DruidDataSource dataSource;

    public void init(Integer connectionId, DbType dbType, String driverClassName, String url, String userName, String password) {
        if (null != dynamicDbDomain || null != dataSource) {
            throw new RuntimeException("链接实体已初始化过");
        }
        dynamicDbDomain = new DynamicDbDomain();
        dataSource = dynamicDbDomain.getDataSource(dbType, driverClassName, url, userName, password);
        this.connectionId = connectionId;
    }

    /**
     * 功能介绍
     * @return
     */

    // 1.外部调用获取链接
    // 2.外部调用关闭链接
    // 3.外部调用获取查询结果

    /**
     * 执行列表查询
     * @param sql
     */
    public <T> List<T> queryList(String sql, Class<T> t) {

        List<DbColumMatch> matchList = new ArrayList<>();

        List<T> resultList = new ArrayList<>();

        DruidPooledConnection connection = dynamicDbDomain.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            System.out.println(preparedStatement.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            int num = 0;
            while (resultSet.next()) {
                T result = (T) t.newInstance();
                if (num == 0) {
                    num++;
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        // String columnName = metaData.getColumnName(i);
                        String columnLabel = metaData.getColumnLabel(i);
                        int columnType = metaData.getColumnType(i);
                        DbColumMatch columMatch = new DbColumMatch();
                        // columMatch.setColumnName(columnName);
                        columMatch.setColumnName(columnLabel);
                        columMatch.setColumnType(columnType);
                        Method setMethod = t.getMethod(columMatch.getSetMethodName(), columMatch.getJavaType());
                        if (null == setMethod)
                            continue;
                        columMatch.setSetMethod(setMethod);
                        matchList.add(columMatch);
                        columMatch.matchRow(resultSet, result);
                    }
                } else {
                    for (int i = 0; i < matchList.size(); i++) {
                        DbColumMatch dbColumMatch = matchList.get(i);
                        dbColumMatch.matchRow(resultSet, result);
                    }
                }

                resultList.add(result);
            }

            return resultList;
        } catch (Exception throwables) {
            throw new RuntimeException(throwables);
        }
    }

    /**
     * 执行单个查询
     * @param sql
     */
    public <T> T queryOne(String sql, Class<T> t) {

        DruidPooledConnection connection = dynamicDbDomain.getConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            System.out.println(preparedStatement.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.last();
            int row = resultSet.getRow();
            if (row > 1) {
                throw new RuntimeException("返回多条");
            }

            resultSet.first();
            if (Integer.class == t || String.class == t) {
                return resultSet.getObject(1, t);
            }

            T result = (T) t.newInstance();
            resultSet.beforeFirst();
            resultSet.next();
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String columnLabel = metaData.getColumnLabel(i);
                int columnType = metaData.getColumnType(i);
                DbColumMatch columMatch = new DbColumMatch();
                columMatch.setColumnName(columnLabel);
                columMatch.setColumnType(columnType);
                Method setMethod = t.getMethod(columMatch.getSetMethodName(), columMatch.getJavaType());
                if (null == setMethod)
                    continue;
                columMatch.setSetMethod(setMethod);
                columMatch.matchRow(resultSet, result);
            }

            return result;
        } catch (Exception throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public boolean matched(Integer connectionId) {
        return this.connectionId == connectionId;
    }

    public void close() {
        dynamicDbDomain.close();
    }
}
