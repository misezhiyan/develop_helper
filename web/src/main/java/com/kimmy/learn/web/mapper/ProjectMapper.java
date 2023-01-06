package com.kimmy.learn.web.mapper;

import com.kimmy.learn.web.controller.domain.request.project.ProjectAddRequest;
import com.kimmy.learn.web.controller.domain.request.project.ProjectDelRequest;
import com.kimmy.learn.web.controller.domain.request.project.ProjectUpdateRequest;
import com.kimmy.learn.web.controller.domain.response.project.ProjectAddResponse;
import com.kimmy.learn.web.controller.domain.response.project.ProjectListResponse;
import com.kimmy.learn.web.entity.db.Menu;
import com.kimmy.learn.web.entity.db.Project;
import com.kimmy.learn.web.entity.domains.MenuTree;
import com.kimmy.learn.web.entity.domains.project.ProjectDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {

    List<Project> list();

    int insert(Project project);

    int update(Project project);

    List<ProjectDetail> detailList();

    int del(Project project);

    Project selectById(Integer id);
}
