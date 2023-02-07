package com.kimmy.learn.web.mapper;

import com.kimmy.learn.web.entity.db.ProjectModule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectModuleMapper {

    int add(ProjectModule projectModule);

    List<ProjectModule> moduleListByProjectCode(String projectCode);

    String maxProjCode();
}
