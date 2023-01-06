package com.kimmy.learn.web.enums;

import com.alibaba.druid.DbType;

public enum DbTypeEnums {
    ;

    private String dbTypeUpper;
    private DbType dbType;

    DbTypeEnums(String dbTypeUpper, DbType dbType) {
        this.dbTypeUpper = dbTypeUpper;
        this.dbType = dbType;
    }

    public static DbType matchDbType(String dbType) {
        if("MYSQL".equals(dbType.toUpperCase()))
            return DbType.mysql;
        return null;
    }
}
