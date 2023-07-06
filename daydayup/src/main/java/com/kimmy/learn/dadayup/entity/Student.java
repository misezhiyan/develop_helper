package com.kimmy.learn.dadayup.entity;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Repository
public class Student {

    // 主键
    private Integer id;
    // 项目编码
    private String projectCode;
    // 模块名称
    private String moduleName;
    // 模块编码
    private String moduleCode;
    // 模块地址
    private String modulePath;
    // java代码地址
    private String javaPackage;
    // 配置文件代码地址
    private String resourcePackage;
    // 前端代码地址
    private String frontPackage;
    // 创建时间
    private Date createTime;

}
