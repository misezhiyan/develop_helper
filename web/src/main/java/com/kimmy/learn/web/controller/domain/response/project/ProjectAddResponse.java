package com.kimmy.learn.web.controller.domain.response.project;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import com.kimmy.learn.web.entity.db.Project;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectAddResponse extends BaseResponse {

    public static ProjectAddResponse success() {
        ProjectAddResponse response = new ProjectAddResponse();
        return response;
    }
}
