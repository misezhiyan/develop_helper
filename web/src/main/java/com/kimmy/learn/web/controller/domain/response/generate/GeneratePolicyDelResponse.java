package com.kimmy.learn.web.controller.domain.response.generate;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class GeneratePolicyDelResponse extends BaseResponse {

    public static GeneratePolicyDelResponse success() {
        GeneratePolicyDelResponse response = new GeneratePolicyDelResponse();
        return response;
    }
}
