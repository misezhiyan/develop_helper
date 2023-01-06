package com.kimmy.learn.web.entity.domains.db;

import com.kimmy.learn.web.entity.domains.db.enums.FieldType;
import com.kimmy.learn.web.util.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ColumnPack extends Column {

    private Boolean isPrimary;
    private String jdbcType;
    private String classType;
    private String className;

    public Boolean getPrimary() {
        return isPrimary;
    }

    public void setPrimary(Boolean primary) {
        isPrimary = primary;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void initForTemplateCreate() {
        this.setPrimary("PRI".equals(columnKey));

        FieldType fieldType = FieldType.matchType(dataType);
        if (null != fieldType) {
            this.setJdbcType(fieldType.getJdbcTypeUpper());
            this.setClassType(fieldType.getJavaType().getTypeName());
        } else {
            this.setJdbcType(null);
            this.setClassType(null);
        }

        this.className = StringUtils.toHumpCase(columnName);
    }
}
