package com.kimmy.learn.web.entity.domains.db;

import com.kimmy.learn.web.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Table {

    protected String tableName;
    protected String tableComment;
    // protected List<? extends Column> columnList;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    // public List<? extends Column> getColumnList() {
    //     return columnList;
    // }
    //
    // public void setColumnList(List<? extends Column> columnList) {
    //     this.columnList = columnList;
    // }

}

