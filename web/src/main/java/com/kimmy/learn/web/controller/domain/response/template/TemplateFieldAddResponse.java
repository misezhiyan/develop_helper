package com.kimmy.learn.web.controller.domain.response.template;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import com.kimmy.learn.web.entity.db.TemplateField;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TemplateFieldAddResponse extends BaseResponse {

    public static TemplateFieldAddResponse success() {
        TemplateFieldAddResponse templateFieldAddResponse = new TemplateFieldAddResponse();
        return templateFieldAddResponse;
    }
}
