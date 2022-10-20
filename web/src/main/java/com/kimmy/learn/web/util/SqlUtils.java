package com.kimmy.learn.web.util;

import com.mysql.cj.MysqlType;

import java.util.Date;

public class SqlUtils {

    public static Class<?> sqlTypeToJavaType(int columnType) {

        switch (MysqlType.getByJdbcType(columnType).getClassName()) {
            case "[B":
                return null;
            default:
                try {
                    return Class.forName(MysqlType.getByJdbcType(columnType).getClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    public static void main(String[] args) {
        System.out.println(MysqlType.getByJdbcType(4));
        System.out.println(MysqlType.getByJdbcType(12));
        System.out.println(MysqlType.getByJdbcType(93));
    }

}
