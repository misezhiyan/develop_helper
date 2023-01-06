package com.kimmy.learn.web.controller;

import com.kimmy.learn.web.controller.domain.request.project.*;
import com.kimmy.learn.web.controller.domain.response.project.*;
import com.kimmy.learn.web.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping("/list")
    public ProjectListResponse list(@RequestBody ProjectListRequest request) {
        return projectService.list(request);
    }

    @RequestMapping("/add")
    public ProjectAddResponse add(@RequestBody ProjectAddRequest request) {
        return projectService.add(request);
    }

    @RequestMapping("/update")
    public ProjectUpdateResponse update(@RequestBody ProjectUpdateRequest request) {
        return projectService.update(request);
    }

    @RequestMapping("/del")
    public ProjectDelResponse del(@RequestBody ProjectDelRequest request) {
        return projectService.del(request);
    }

    @RequestMapping("/generateFiles")
    public GenerateFilesResponse generateFiles(@RequestBody GenerateFilesRequest request) {
        return projectService.generateFiles(request);
    }

}
