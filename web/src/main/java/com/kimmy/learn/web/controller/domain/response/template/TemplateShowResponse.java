package com.kimmy.learn.web.controller.domain.response.template;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class TemplateShowResponse extends BaseResponse {

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static TemplateShowResponse success(String result) {
        TemplateShowResponse templateFieldAddResponse = new TemplateShowResponse();
        templateFieldAddResponse.setResult(result);
        return templateFieldAddResponse;
    }

    public TemplateShowResponse fail(String msg) {
        TemplateShowResponse templateFieldAddResponse = new TemplateShowResponse();
        templateFieldAddResponse.setResCode("9999");
        templateFieldAddResponse.setResMsg(msg);
        return templateFieldAddResponse;
    }
}
