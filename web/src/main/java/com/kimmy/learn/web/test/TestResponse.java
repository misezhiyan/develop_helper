package com.kimmy.learn.web.test;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class TestResponse extends BaseResponse {

    public static TestResponse success() {
        TestResponse response = new TestResponse();
        return response;
    }
}
