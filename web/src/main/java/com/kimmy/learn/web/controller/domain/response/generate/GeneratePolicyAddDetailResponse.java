package com.kimmy.learn.web.controller.domain.response.generate;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class GeneratePolicyAddDetailResponse extends BaseResponse {

    public static GeneratePolicyAddDetailResponse success() {
        GeneratePolicyAddDetailResponse response = new GeneratePolicyAddDetailResponse();
        return response;
    }
}
