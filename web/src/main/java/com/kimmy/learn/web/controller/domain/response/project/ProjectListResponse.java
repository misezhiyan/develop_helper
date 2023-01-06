package com.kimmy.learn.web.controller.domain.response.project;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import com.kimmy.learn.web.entity.db.Project;
import com.kimmy.learn.web.entity.db.Template;
import com.kimmy.learn.web.entity.domains.project.ProjectDetail;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectListResponse extends BaseResponse {

    List<ProjectDetail> projectList;

    public List<ProjectDetail> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<ProjectDetail> projectList) {
        this.projectList = projectList;
    }

    public static ProjectListResponse success(List<ProjectDetail> list) {
        ProjectListResponse response = new ProjectListResponse();
        response.setProjectList(list);
        return response;
    }
}
