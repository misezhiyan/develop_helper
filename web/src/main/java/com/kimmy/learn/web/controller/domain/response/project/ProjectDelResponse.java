package com.kimmy.learn.web.controller.domain.response.project;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class ProjectDelResponse extends BaseResponse {

    public static ProjectDelResponse success() {
        ProjectDelResponse response = new ProjectDelResponse();
        return response;
    }
}
