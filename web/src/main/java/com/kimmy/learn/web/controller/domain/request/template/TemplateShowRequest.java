package com.kimmy.learn.web.controller.domain.request.template;

import com.kimmy.learn.web.entity.db.Template;
import com.kimmy.learn.web.entity.domains.template.TemplateFieldExtend;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TemplateShowRequest extends Template {

    private List<TemplateFieldExtend> fieldList;

    public List<TemplateFieldExtend> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<TemplateFieldExtend> fieldList) {
        this.fieldList = fieldList;
    }
}
