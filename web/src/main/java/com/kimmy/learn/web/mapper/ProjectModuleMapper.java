package com.kimmy.learn.web.mapper;

import com.kimmy.learn.web.controller.domain.request.project.ProjectModuleDelRequest;
import com.kimmy.learn.web.controller.domain.request.project.ProjectModuleUpdRequest;
import com.kimmy.learn.web.entity.db.ProjectModule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectModuleMapper {

    int add(ProjectModule projectModule);

    int update(ProjectModule projectModule);

    int delete(ProjectModule projectModule);

    List<ProjectModule> moduleListByProjectCode(String projectCode);

    String maxProjCode();

}
