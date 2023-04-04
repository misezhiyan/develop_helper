package com.kimmy.learn.web.controller.domain.response.project;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class ProjectModuleUpdResponse extends BaseResponse {

    public static ProjectModuleUpdResponse success() {
        ProjectModuleUpdResponse response = new ProjectModuleUpdResponse();
        return response;
    }
}
