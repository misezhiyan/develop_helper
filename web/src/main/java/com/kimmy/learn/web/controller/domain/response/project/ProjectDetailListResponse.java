package com.kimmy.learn.web.controller.domain.response.project;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import com.kimmy.learn.web.entity.db.Project;
import com.kimmy.learn.web.entity.domains.project.ProjectModules;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectDetailListResponse extends BaseResponse {

    List<ProjectModules> projectList;

    public List<ProjectModules> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<ProjectModules> projectList) {
        this.projectList = projectList;
    }

    public static ProjectDetailListResponse success(List<ProjectModules> list) {
        ProjectDetailListResponse response = new ProjectDetailListResponse();
        response.setProjectList(list);
        return response;
    }
}
