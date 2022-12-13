package com.kimmy.learn.web.controller.domain.response.template;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import com.kimmy.learn.web.entity.db.Template;
import com.kimmy.learn.web.entity.db.TemplateField;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TemplateListResponse extends BaseResponse {

    List<Template> templateList;

    public List<Template> getTemplateList() {
        return templateList;
    }

    public void setTemplateList(List<Template> templateList) {
        this.templateList = templateList;
    }

    public static TemplateListResponse success(List<Template> list) {
        TemplateListResponse templateListResponse = new TemplateListResponse();
        templateListResponse.setTemplateList(list);
        return templateListResponse;
    }
}
