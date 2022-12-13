package com.kimmy.learn.web.entity.domains.db;

import com.kimmy.learn.web.entity.domains.db.enums.FieldType;
import com.kimmy.learn.web.util.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ColumnPack extends Column {

    private Boolean isPrimary;
    private String jdbcType;
    private String className;

    public void setColumnType(String columnType) {
        this.columnType = columnType;
        this.setPrimary("PRI".equals(columnType));
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
        FieldType fieldType = FieldType.matchType(dataType);
        if (null != fieldType) {
            this.setJdbcType(fieldType.getJdbcTypeUpper());
        } else {
            this.setJdbcType(null);
        }
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public void setPrimary(Boolean primary) {
        isPrimary = primary;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
        this.className = StringUtils.toHumpCase(columnName);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getJdbcType() {
        return jdbcType;
    }
}
