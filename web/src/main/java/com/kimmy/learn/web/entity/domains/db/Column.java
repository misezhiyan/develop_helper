package com.kimmy.learn.web.entity.domains.db;

import com.kimmy.learn.web.util.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class Column {

    protected String columnName;
    protected String dataType;
    protected String columnType;
    protected String columnKey;
    protected String extra;
    protected String columnComment;

    // private String fieldName;
    // private FieldType fieldType;
    // private Boolean isPramary;
    // private String className;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }


}
