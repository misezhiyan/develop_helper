package com.daydayup.entity;

import lombok.Data;

import java.util.Date;

/**
 * @discription 排课表
 * @author kimmy
 * @date ${date}
 */
@Data
public class Schedule {
    private Integer id;
    private Integer teacherId;
    private Date scheduleDate;
    private String start;
    private String end;
    private String status;
    private Date createTime;
}
