package com.kimmy.learn.web.entity.domains.project;

import com.kimmy.learn.web.entity.db.ProjectModuleComponent;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class ProjectComponent extends ProjectModuleComponent {

    // 模块编码
    private String relyComponentName;
}
