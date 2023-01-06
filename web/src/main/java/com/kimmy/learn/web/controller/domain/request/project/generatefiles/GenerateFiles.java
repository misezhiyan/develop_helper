package com.kimmy.learn.web.controller.domain.request.project.generatefiles;

public class GenerateFiles {

    private Integer dbId;
    private String dbNickName;
    private String tableName;
    private Integer policyId;
    private String policyName;

    public Integer getDbId() {
        return dbId;
    }

    public void setDbId(Integer dbId) {
        this.dbId = dbId;
    }

    public String getDbNickName() {
        return dbNickName;
    }

    public void setDbNickName(String dbNickName) {
        this.dbNickName = dbNickName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }
}
