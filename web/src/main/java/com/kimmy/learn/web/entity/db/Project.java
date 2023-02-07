package com.kimmy.learn.web.entity.db;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Repository
public class Project {

    // 主键
    private Integer id;
    // 项目编码
    private String projectCode;
    // 项目名称
    private String projectName;
    // 项目基本路径
    private String baseUrl;
    // 创建时间
    private Date createTime;
    // 创建人
    private Date createUser;

}
