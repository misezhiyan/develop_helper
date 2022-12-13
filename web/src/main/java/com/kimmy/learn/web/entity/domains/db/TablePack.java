package com.kimmy.learn.web.entity.domains.db;

import com.kimmy.learn.web.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TablePack extends Table {

    private String className;
    private List<ColumnPack> columnList;

    public void setTableName(String tableName) {
        this.tableName = tableName;
        this.className = StringUtils.toClassName(tableName);
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public List<ColumnPack> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<ColumnPack> columnList) {
        this.columnList = columnList;
    }
}

