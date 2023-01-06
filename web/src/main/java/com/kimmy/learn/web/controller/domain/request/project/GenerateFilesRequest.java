package com.kimmy.learn.web.controller.domain.request.project;

import com.kimmy.learn.web.controller.domain.request.project.generatefiles.GenerateFiles;
import com.kimmy.learn.web.entity.db.ProjDbMapping;
import com.kimmy.learn.web.entity.db.Project;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenerateFilesRequest {

    private Integer projectId;
    private List<GenerateFiles> generateTables;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public List<GenerateFiles> getGenerateTables() {
        return generateTables;
    }

    public void setGenerateTables(List<GenerateFiles> generateTables) {
        this.generateTables = generateTables;
    }
}
