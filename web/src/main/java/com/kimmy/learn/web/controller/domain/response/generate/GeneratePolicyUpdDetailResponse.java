package com.kimmy.learn.web.controller.domain.response.generate;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class GeneratePolicyUpdDetailResponse extends BaseResponse {

    public static GeneratePolicyUpdDetailResponse success() {
        GeneratePolicyUpdDetailResponse response = new GeneratePolicyUpdDetailResponse();
        return response;
    }
}
