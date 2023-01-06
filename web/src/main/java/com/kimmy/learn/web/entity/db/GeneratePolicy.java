package com.kimmy.learn.web.entity.db;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class GeneratePolicy {

    private Integer id;
    private String policyName;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
