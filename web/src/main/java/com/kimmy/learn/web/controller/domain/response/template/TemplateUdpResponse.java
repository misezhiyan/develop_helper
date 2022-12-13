package com.kimmy.learn.web.controller.domain.response.template;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class TemplateUdpResponse extends BaseResponse {

    public static TemplateUdpResponse success() {
        return new TemplateUdpResponse();
    }
}
