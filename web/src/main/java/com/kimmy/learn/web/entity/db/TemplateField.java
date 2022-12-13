package com.kimmy.learn.web.entity.db;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class TemplateField {

    // 主键
    private Integer id;
    // 模板ID
    private Integer templateId;
    // 参数名称
    private String fieldName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
