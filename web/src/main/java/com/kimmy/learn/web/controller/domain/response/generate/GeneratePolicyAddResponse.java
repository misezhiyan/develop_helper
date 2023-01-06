package com.kimmy.learn.web.controller.domain.response.generate;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import com.kimmy.learn.web.entity.db.GeneratePolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeneratePolicyAddResponse extends BaseResponse {

    public static GeneratePolicyAddResponse success() {
        GeneratePolicyAddResponse response = new GeneratePolicyAddResponse();
        return response;
    }
}
