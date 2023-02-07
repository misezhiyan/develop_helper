package com.kimmy.learn.web.entity.domains.project;

import com.kimmy.learn.web.entity.db.DbConnectConfig;
import com.kimmy.learn.web.entity.db.Project;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ProjectDbs extends Project {

    private List<DbConnectConfig> dbList;

    public List<DbConnectConfig> getDbList() {
        return dbList;
    }

    public void setDbList(List<DbConnectConfig> dbList) {
        this.dbList = dbList;
    }
}
