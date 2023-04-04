package com.kimmy.learn.web.controller.domain.response.project;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class ProjectModuleComponentAddResponse extends BaseResponse {

    public static ProjectModuleComponentAddResponse success() {
        ProjectModuleComponentAddResponse response = new ProjectModuleComponentAddResponse();
        return response;
    }
}
