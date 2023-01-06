package com.kimmy.learn.web.controller.domain.response.generate;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class GeneratePolicyDelDetailResponse extends BaseResponse {

    public static GeneratePolicyDelDetailResponse success() {
        GeneratePolicyDelDetailResponse response = new GeneratePolicyDelDetailResponse();
        return response;
    }
}
