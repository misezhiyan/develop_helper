package com.kimmy.learn.web.controller.domain.response.project;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class ProjectModuleDelResponse extends BaseResponse {

    public static ProjectModuleDelResponse success() {
        ProjectModuleDelResponse response = new ProjectModuleDelResponse();
        return response;
    }
}
