package com.kimmy.learn.web.controller.domain.response.template;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class TemplateAddResponse extends BaseResponse {

    public static TemplateAddResponse success() {
        return new TemplateAddResponse();
    }
}
