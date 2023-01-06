package com.kimmy.learn.web.entity.db;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class Project {

    // 主键
    private Integer id;
    // 项目名称
    private String projectName;
    // 项目基本路径
    private String baseUrl;
    // 创建时间
    private Date createTime;
    // 创建人
    private Date createUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Date createUser) {
        this.createUser = createUser;
    }
}
