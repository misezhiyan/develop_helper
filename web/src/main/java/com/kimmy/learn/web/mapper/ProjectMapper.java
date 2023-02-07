package com.kimmy.learn.web.mapper;

import com.kimmy.learn.web.controller.domain.request.project.ProjModulesListRequest;
import com.kimmy.learn.web.entity.db.Project;
import com.kimmy.learn.web.entity.domains.project.ProjectDbs;
import com.kimmy.learn.web.entity.domains.project.ProjectModules;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {

    String maxProjectCode();
    int insert(Project project);
    List<Project> list();
    int update(Project project);


    List<ProjectModules> projModulesList(ProjModulesListRequest request);




    List<ProjectDbs> detailDbList();

    int del(Project project);

    Project selectById(Integer id);

}
