package com.kimmy.learn.web.mapper;

import com.kimmy.learn.web.entity.db.ProjectModuleComponent;
import com.kimmy.learn.web.entity.domains.project.ProjectComponent;
import com.kimmy.learn.web.entity.domains.project.ProjectComponentRelyTree;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectModuleComponentMapper {

    int add(ProjectModuleComponent projectModuleComponent);

    int update(ProjectModuleComponent projectModuleComponent);

    int delete(ProjectModuleComponent projectModuleComponent);

    List<ProjectComponent> listByModuleCode(String moduleCode);

    String maxCode();

    String nameByModuleCode(String componentCode);

}
