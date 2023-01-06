package com.kimmy.learn.web.controller.domain.request.project;

import com.kimmy.learn.web.entity.db.DbConnectConfig;
import com.kimmy.learn.web.entity.db.ProjDbMapping;
import com.kimmy.learn.web.entity.db.Project;
import com.kimmy.learn.web.entity.domains.db.DB;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectAddRequest extends Project {

    private List<ProjDbMapping> dbList;

    public List<ProjDbMapping> getDbList() {
        return dbList;
    }

    public void setDbList(List<ProjDbMapping> dbList) {
        this.dbList = dbList;
    }
}
