package com.kimmy.learn.web.controller.domain.response.project;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class ProjectModuleComponentDelResponse extends BaseResponse {

    public static ProjectModuleComponentDelResponse success() {
        ProjectModuleComponentDelResponse response = new ProjectModuleComponentDelResponse();
        return response;
    }
}
