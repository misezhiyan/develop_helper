package com.kimmy.learn.web.controller.domain.response.project;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class ProjectModuleComponentUpdResponse extends BaseResponse {

    public static ProjectModuleComponentUpdResponse success() {
        ProjectModuleComponentUpdResponse response = new ProjectModuleComponentUpdResponse();
        return response;
    }
}
