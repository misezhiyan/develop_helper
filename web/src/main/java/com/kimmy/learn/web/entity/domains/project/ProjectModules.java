package com.kimmy.learn.web.entity.domains.project;

import com.kimmy.learn.web.entity.db.Project;
import com.kimmy.learn.web.entity.db.ProjectModule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectModules extends Project {

    List<ProjectModule> moduleList;

    public List<ProjectModule> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<ProjectModule> moduleList) {
        this.moduleList = moduleList;
    }
}
