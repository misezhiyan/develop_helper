package com.kimmy.learn.web.controller.domain.response.project;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class GenerateFilesResponse extends BaseResponse {

    public static GenerateFilesResponse success() {
        GenerateFilesResponse response = new GenerateFilesResponse();
        return response;
    }
}
