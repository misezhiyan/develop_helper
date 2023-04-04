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

    // @RequestMapping("/list")
    // public ProjectListResponse list(@RequestBody ProjectListRequest request) {
    //     return projectService.list(request);
    // }
    //
    // @RequestMapping("/add")
    // public ProjectAddResponse add(@RequestBody ProjectAddRequest request) {
    //     return projectService.add(request);
    // }
    //
    // @RequestMapping("/update")
    // public ProjectUpdateResponse update(@RequestBody ProjectUpdateRequest request) {
    //     return projectService.update(request);
    // }
    //
    // @RequestMapping("/del")
    // public ProjectDelResponse del(@RequestBody ProjectDelRequest request) {
    //     return projectService.del(request);
    // }
    //
    // @RequestMapping("/generateFiles")
    // public GenerateFilesResponse generateFiles(@RequestBody GenerateFilesRequest request) {
    //     return projectService.generateFiles(request);
    // }

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

    @RequestMapping("/projModulesList")
    public ProjModulesListResponse projModulesList(@RequestBody ProjModulesListRequest request) {
        return projectService.projModulesList(request);
    }

    @RequestMapping("/addModule")
    public ProjectModuleAddResponse addModule(@RequestBody ProjectModuleAddRequest request) {
        return projectService.addModule(request);
    }

    @RequestMapping("/updModule")
    public ProjectModuleUpdResponse updModule(@RequestBody ProjectModuleUpdRequest request) {
        return projectService.updModule(request);
    }

    @RequestMapping("/delModule")
    public ProjectModuleDelResponse delModule(@RequestBody ProjectModuleDelRequest request) {
        return projectService.delModule(request);
    }

    @RequestMapping("/projComponentList")
    public ProjectModuleComponentListResponse projComponentList(@RequestBody ProjectComponentListRequest request) {
        return projectService.projComponentList(request);
    }

    @RequestMapping("/projComponentRelyTreeList")
    public ProjectModuleComponentRelyTreeListResponse projComponentRelyTreeList(@RequestBody ProjectComponentListRequest request) {
        return projectService.projComponentRelyTreeList(request);
    }

    @RequestMapping("/addComponent")
    public ProjectModuleComponentAddResponse addComponent(@RequestBody ProjectComponentAddRequest request) {
        return projectService.addComponent(request);
    }

    @RequestMapping("/updComponent")
    public ProjectModuleComponentUpdResponse updComponent(@RequestBody ProjectComponentUpdRequest request) {
        return projectService.updComponent(request);
    }

    @RequestMapping("/delComponent")
    public ProjectModuleComponentDelResponse delComponent(@RequestBody ProjectComponentDelRequest request) {
        return projectService.delComponent(request);
    }

}
