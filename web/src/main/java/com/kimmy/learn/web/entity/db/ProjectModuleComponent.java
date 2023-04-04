package com.kimmy.learn.web.entity.db;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Repository
public class ProjectModuleComponent {

    // 主键
    private Integer id;
    // 模块编码
    private String moduleCode;
    // 组件名称
    private String componentName;
    // 组件编码
    private String componentCode;
    // 组件标识
    private String componentFlag;
    // 创建时间
    private Date createTime;

}
