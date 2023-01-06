package com.kimmy.learn.web.entity.domains.db.enums;

import com.alibaba.druid.util.StringUtils;

import java.util.Arrays;
import java.util.Date;

public enum FieldType {

    MYSQL_VARCHAR(DBType.MYSQL, "VARCHAR","VARCHAR", String.class),
    MYSQL_INT(DBType.MYSQL, "INT","INTEGER",  Integer.class),
    MYSQL_TINYINT(DBType.MYSQL, "TINYINT","INTEGER",  Integer.class),
    MYSQL_DATETIME(DBType.MYSQL, "DATETIME","TIMESTAMP", Date.class),
    MYSQL_LONGTEXT(DBType.MYSQL, "LONGTEXT", "VARCHAR", String.class),
    ;

    private DBType dbType;
    private String dbFiledTypeUpper;
    private String jdbcTypeUpper;
    private Class javaType;

    FieldType(DBType dbType, String dbFiledTypeUpper, String jdbcTypeUpper, Class javaType) {
        this.dbType = dbType;
        this.dbFiledTypeUpper = dbFiledTypeUpper;
        this.jdbcTypeUpper = jdbcTypeUpper;
        this.javaType = javaType;
    }

    public String getJdbcTypeUpper() {
        return jdbcTypeUpper;
    }

    public Class getJavaType() {
        return javaType;
    }

    public static FieldType matchType(String fieldType) {
        if(StringUtils.isEmpty(fieldType))
            return null;
        return Arrays.stream(FieldType.values()).filter(type -> type.dbFiledTypeUpper.equals(fieldType.toUpperCase())).findAny().orElse(null);
    }
}
