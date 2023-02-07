package com.kimmy.learn.web.controller.domain.response.project;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import com.kimmy.learn.web.entity.db.Project;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectListResponse extends BaseResponse {

    List<Project> projectList;

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public static ProjectListResponse success(List<Project> list) {
        ProjectListResponse response = new ProjectListResponse();
        response.setProjectList(list);
        return response;
    }
}
