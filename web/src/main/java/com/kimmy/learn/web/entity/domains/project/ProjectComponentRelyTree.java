package com.kimmy.learn.web.entity.domains.project;

import com.kimmy.learn.web.entity.db.ProjectModuleComponent;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class ProjectComponentRelyTree extends ProjectModuleComponent {

    // 模块编码
    private String relyComponentName;

    public static List<ProjectComponentRelyTree> treeList(List<ProjectComponent> list) {

        // list.stream().filter(component -> component.getRelyComponentName())

        return new ArrayList<>();
    }
}
