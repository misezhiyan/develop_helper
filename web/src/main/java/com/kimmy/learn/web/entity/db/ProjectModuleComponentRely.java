package com.kimmy.learn.web.entity.db;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Repository
public class ProjectModuleComponentRely {

    // 主键
    private Integer id;
    // 组件编码
    private String componentCode;
    // 依赖组件
    private String relyComponentCode;
    // 创建时间
    private Date createTime;

}
