package com.kimmy.learn.web.entity.domains.template;

import com.kimmy.learn.web.entity.db.GeneratePolicyDetail;

public class GeneratePolicyDetailExtend extends GeneratePolicyDetail {

    private String templateName;

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
