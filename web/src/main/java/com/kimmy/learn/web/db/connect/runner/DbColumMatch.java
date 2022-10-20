package com.kimmy.learn.web.db.connect.runner;

import com.kimmy.learn.web.util.ReflectUtils;
import com.kimmy.learn.web.util.SqlUtils;
import com.kimmy.learn.web.util.StringUtils;
import com.mysql.cj.MysqlType;
import org.springframework.stereotype.Repository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;

@Repository
public class DbColumMatch {

    private String columnName;
    private int columnType;

    private Method setMethod;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Method getSetMethod() {
        return setMethod;
    }

    public void setSetMethod(Method setMethod) {
        this.setMethod = setMethod;
    }

    public int getColumnType() {
        return columnType;
    }

    public void setColumnType(int columnType) {
        this.columnType = columnType;
    }

    /**
     * set方法名称
     * @return
     */
    public String getSetMethodName() {
        return StringUtils.toHumpCase("set_" + columnName);
    }

    /**
     * sql类型转java类型
     * @return
     */
    public Class<?> getJavaType() {
        return transferType(SqlUtils.sqlTypeToJavaType(columnType));
    }

    /**
     * java类型转换
     * @param sqlTypeToJavaType
     * @return
     */
    private Class<?> transferType(Class<?> sqlTypeToJavaType) {
        if(Timestamp.class == sqlTypeToJavaType){
            return java.util.Date.class;
        }
        return sqlTypeToJavaType;
    }

    /**
     * 匹配一行数据
     * @param resultSet
     * @param t
     * @param <T>
     */
    public <T> void matchRow(ResultSet resultSet, T t) {

        try {
            if (SqlUtils.sqlTypeToJavaType(columnType) == Integer.class) {
                setMethod.invoke(t, resultSet.getInt(columnName));
            } else if (SqlUtils.sqlTypeToJavaType(columnType) == String.class) {
                setMethod.invoke(t, resultSet.getString(columnName));
            } else if (SqlUtils.sqlTypeToJavaType(columnType) == Date.class) {
                setMethod.invoke(t, resultSet.getDate(columnName));
            }
        } catch (Exception throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
