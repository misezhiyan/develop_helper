package com.kimmy.learn.web.entity.db;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class Template {

    // 主键
    private Integer templateId;
    // 模板名称
    private String templateName;
    // 模板内容
    private String templateContent;
    // 创建时间
    private Date createTime;

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
