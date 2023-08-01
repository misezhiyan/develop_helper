package com.daydayup.entity;

import java.util.Date;

/**
 * @discription 用户信息表
 * @author kimmy
 * @date ${date}
 */
public class User {

    private Integer userId;
    private String account;
    private String password;
    private Integer wrongTimes;
    private Date wrongDate;
    private String status;
    private Date createTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getWrongTimes() {
        return wrongTimes;
    }

    public void setWrongTimes(Integer wrongTimes) {
        this.wrongTimes = wrongTimes;
    }

    public Date getWrongDate() {
        return wrongDate;
    }

    public void setWrongDate(Date wrongDate) {
        this.wrongDate = wrongDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
