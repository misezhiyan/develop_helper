package com.kimmy.learn.web.entity.db;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class GeneratePolicyDetail {

    private Integer id;
    private Integer policyId;
    private String nickName;
    private String generateName;
    private String generateSrcPath;
    private String generateRelativePath;
    private String generateFilesuffix;
    private String importRule;
    private Integer templateId;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGenerateName() {
        return generateName;
    }

    public void setGenerateName(String generateName) {
        this.generateName = generateName;
    }

    public String getGenerateSrcPath() {
        return generateSrcPath;
    }

    public void setGenerateSrcPath(String generateSrcPath) {
        this.generateSrcPath = generateSrcPath;
    }

    public String getGenerateRelativePath() {
        return generateRelativePath;
    }

    public void setGenerateRelativePath(String generateRelativePath) {
        this.generateRelativePath = generateRelativePath;
    }

    public String getGenerateFilesuffix() {
        return generateFilesuffix;
    }

    public void setGenerateFilesuffix(String generateFilesuffix) {
        this.generateFilesuffix = generateFilesuffix;
    }

    public String getImportRule() {
        return importRule;
    }

    public void setImportRule(String importRule) {
        this.importRule = importRule;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
