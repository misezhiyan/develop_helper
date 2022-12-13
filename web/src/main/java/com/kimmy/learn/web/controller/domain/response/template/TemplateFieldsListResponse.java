package com.kimmy.learn.web.controller.domain.response.template;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import com.kimmy.learn.web.entity.db.Template;
import com.kimmy.learn.web.entity.db.TemplateField;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TemplateFieldsListResponse extends BaseResponse {

    List<TemplateField> fieldsList;

    public List<TemplateField> getFieldsList() {
        return fieldsList;
    }

    public void setFieldsList(List<TemplateField> fieldsList) {
        this.fieldsList = fieldsList;
    }

    public static TemplateFieldsListResponse success(List<TemplateField> list) {
        TemplateFieldsListResponse templateListResponse = new TemplateFieldsListResponse();
        templateListResponse.setFieldsList(list);
        return templateListResponse;
    }
}
