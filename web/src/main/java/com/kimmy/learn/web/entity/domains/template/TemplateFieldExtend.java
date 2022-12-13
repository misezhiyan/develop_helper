package com.kimmy.learn.web.entity.domains.template;

import com.kimmy.learn.web.entity.db.TemplateField;
import org.springframework.stereotype.Repository;

@Repository
public class TemplateFieldExtend extends TemplateField {

    // 参数名称
    private String fieldValue;

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
