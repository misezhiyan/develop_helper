package com.kimmy.learn.web.controller.domain.response.project;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class ProjectUpdateResponse extends BaseResponse {

    public static ProjectUpdateResponse success() {
        ProjectUpdateResponse response = new ProjectUpdateResponse();
        return response;
    }
}
