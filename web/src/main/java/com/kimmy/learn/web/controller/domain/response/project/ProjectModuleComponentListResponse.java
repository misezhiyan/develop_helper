package com.kimmy.learn.web.controller.domain.response.project;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import com.kimmy.learn.web.entity.db.ProjectModuleComponent;
import com.kimmy.learn.web.entity.domains.project.ProjectComponent;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class ProjectModuleComponentListResponse extends BaseResponse {

    List<ProjectComponent> list;

    public static ProjectModuleComponentListResponse success(List<ProjectComponent> list) {
        ProjectModuleComponentListResponse response = new ProjectModuleComponentListResponse();
        response.setList(list);
        return response;
    }
}
