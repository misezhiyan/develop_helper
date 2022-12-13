package com.kimmy.learn.web.entity.domains.db;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DB {

    private String dbName;
    private List<Table> tableList;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }
}
