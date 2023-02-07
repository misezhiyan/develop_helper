package com.kimmy.learn.web.controller.domain.response.project;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class ProjectModuleAddResponse extends BaseResponse {

    public static ProjectModuleAddResponse success() {
        ProjectModuleAddResponse response = new ProjectModuleAddResponse();
        return response;
    }
}
