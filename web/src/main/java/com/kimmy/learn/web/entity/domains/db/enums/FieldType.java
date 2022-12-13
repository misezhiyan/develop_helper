package com.kimmy.learn.web.entity.domains.db.enums;

import com.alibaba.druid.util.StringUtils;

import java.util.Arrays;
import java.util.Date;

public enum FieldType {

    MYSQL_VARCHAR(DBType.MYSQL, "VARCHAR", String.class),
    MYSQL_INT(DBType.MYSQL, "INT", Integer.class),
    MYSQL_DATETIME(DBType.MYSQL, "DATETIME",Date.class),
    MYSQL_LONGTEXT(DBType.MYSQL, "LONGTEXT", String.class),
    ;

    private DBType dbType;
    private String jdbcTypeUpper;
    private Class javaType;

    FieldType(DBType dbType, String typeUpper, Class javaType) {
        this.dbType = dbType;
        this.jdbcTypeUpper = typeUpper;
        this.javaType = javaType;
    }

    public String getJdbcTypeUpper() {
        return jdbcTypeUpper;
    }

    public static FieldType matchType(String fieldType) {
        if(StringUtils.isEmpty(fieldType))
            return null;
        return Arrays.stream(FieldType.values()).filter(type -> type.jdbcTypeUpper.equals(fieldType.toUpperCase())).findAny().get();
    }
}
