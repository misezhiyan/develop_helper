package com.kimmy.learn.web.service;

import com.kimmy.learn.web.controller.domain.request.project.*;
import com.kimmy.learn.web.controller.domain.request.project.generatefiles.GenerateFiles;
import com.kimmy.learn.web.controller.domain.response.project.*;

public interface ProjectService {

    ProjectListResponse list(ProjectListRequest request);

    ProjectAddResponse add(ProjectAddRequest request);

    ProjectUpdateResponse update(ProjectUpdateRequest request);

    ProjectDelResponse del(ProjectDelRequest request);

    GenerateFilesResponse generateFiles(GenerateFilesRequest request);

    void generateProjTemplate(Integer projectId, GenerateFiles generateFiles);

    ProjectModuleAddResponse addModule(ProjectModuleAddRequest request);

    ProjectDetailListResponse projModulesList(ProjModulesListRequest request);
}
