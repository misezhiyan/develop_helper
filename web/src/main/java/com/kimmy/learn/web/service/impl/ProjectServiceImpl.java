package com.kimmy.learn.web.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.kimmy.learn.web.controller.domain.request.project.*;
import com.kimmy.learn.web.controller.domain.request.project.generatefiles.GenerateFiles;
import com.kimmy.learn.web.controller.domain.response.project.*;
import com.kimmy.learn.web.db.connect.DynamicDbManager;
import com.kimmy.learn.web.db.connect.DynamicDbRunner;
import com.kimmy.learn.web.entity.db.*;
import com.kimmy.learn.web.entity.domains.db.ColumnPack;
import com.kimmy.learn.web.entity.domains.db.TablePack;
import com.kimmy.learn.web.entity.domains.generate.PolicyDetail;
import com.kimmy.learn.web.entity.domains.project.ProjectComponent;
import com.kimmy.learn.web.entity.domains.project.ProjectComponentRelyTree;
import com.kimmy.learn.web.entity.domains.template.TemplateParams;
import com.kimmy.learn.web.mapper.*;
import com.kimmy.learn.web.service.ProjectService;
import com.kimmy.learn.web.template.TemplateMatcher;
import com.kimmy.learn.web.util.FileUtils;
import com.kimmy.learn.web.util.IdUtils;
import com.kimmy.learn.web.util.PathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    ProjectModuleMapper projectModuleMapper;
    @Autowired
    ProjectModuleComponentMapper projectModuleComponentMapper;
    @Autowired
    ProjDbMappingMapper projDbMappingMapper;
    @Autowired
    DbConnectConfigMapper dbConnectConfigMapper;
    @Autowired
    GeneratePolicyMapper generatePolicyMapper;
    @Autowired
    TemplateMapper templateMapper;

    @Autowired
    DynamicDbManager dynamicDbManager;
    @Autowired
    TemplateMatcher templateMatcher;

    @Override
    public ProjectListResponse list(ProjectListRequest request) {
        return ProjectListResponse.success(projectMapper.list());
    }

    @Override
    public ProjectAddResponse add(ProjectAddRequest request) {

        String maxProjectCode = projectMapper.maxProjectCode();
        Integer seriaNo = 0;
        if (StringUtils.isEmpty(maxProjectCode)) {
            seriaNo = Integer.parseInt(maxProjectCode.substring("PROJ".length()));
        }
        String projectCode = IdUtils.combineSeriaNo("PROJ", seriaNo + 1, 10);
        request.setProjectCode(projectCode);
        projectMapper.insert(request);
        // List<ProjDbMapping> dbList = request.getDbList();
        // if (!CollectionUtils.isEmpty(dbList)) {
        //     dbList.forEach(db -> db.setProjId(request.getId()));
        //     projDbMappingMapper.insertBatch(dbList);
        // }
        return ProjectAddResponse.success();
    }

    @Override
    public ProjectUpdateResponse update(ProjectUpdateRequest request) {
        projectMapper.update(request);
        // projDbMappingMapper.delByProj(request.getId());
        // List<ProjDbMapping> dbList = request.getDbList();
        // if (!CollectionUtils.isEmpty(dbList)) {
        //     dbList.forEach(db -> db.setProjId(request.getId()));
        //     projDbMappingMapper.insertBatch(dbList);
        // }
        return ProjectUpdateResponse.success();
    }

    @Override
    public ProjectDelResponse del(ProjectDelRequest request) {
        projectMapper.del(request);
        return ProjectDelResponse.success();
    }

    @Override
    public GenerateFilesResponse generateFiles(GenerateFilesRequest request) {

        List<GenerateFiles> generateTables = request.getGenerateTables();

        for (int i = 0; i < generateTables.size(); i++) {
            generateProjTemplate(request.getProjectId(), generateTables.get(i));
        }

        return GenerateFilesResponse.success();
    }

    public void generateProjTemplate(Integer projectId, GenerateFiles generateFiles) {
        Integer dbId = generateFiles.getDbId();
        String tableName = generateFiles.getTableName();

        TablePack table = null;
        DbConnectConfig dbConfig = dbConnectConfigMapper.getDbConfig(dbId);
        DynamicDbRunner runner = null;
        try {
            runner = dynamicDbManager.getRunner(dbConfig);
            String sql = "SELECT `TABLE_NAME` tableName, TABLE_COMMENT tableComment FROM information_schema.TABLES t WHERE TABLE_SCHEMA = '" + dbConfig.getDefaultConnectDb() + "' AND TABLE_NAME = '" + tableName + "'";
            table = runner.queryOne(sql, TablePack.class);
            String columnSql = "SELECT column_name, data_type, column_type, column_key, extra, column_comment FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '" + dbConfig.getDefaultConnectDb() + "' AND table_name = '" + tableName + "' " + "ORDER BY ordinal_position";
            List<ColumnPack> columnPacks = runner.queryList(columnSql, ColumnPack.class);
            table.setColumnList(columnPacks);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != runner) {
                runner.close();
            }
        }

        Integer policyId = generateFiles.getPolicyId();

        Project project = projectMapper.selectById(projectId);
        PolicyDetail policyDetail = generatePolicyMapper.policyDetail(policyId);

        table.setPolicyDetail(policyDetail);

        // table
        TemplateParams params = new TemplateParams();
        params.put("table", table.initForTemplateCreate());

        String baseUrl = project.getBaseUrl();
        for (int i = 0; i < policyDetail.getDetailList().size(); i++) {

            GeneratePolicyDetail generatePolicyDetail = policyDetail.getDetailList().get(i);

            try {
                String generateSrcPath = generatePolicyDetail.getGenerateSrcPath();
                String generateRelativePath = generatePolicyDetail.getGenerateRelativePath();
                String generateName = generatePolicyDetail.getGenerateName();

                Integer templateId = generatePolicyDetail.getTemplateId();
                Template detail = templateMapper.detail(templateId);

                String fileName = templateMatcher.matchStrToStr("fileName", generateName, params) + FileUtils.POINT + generatePolicyDetail.getGenerateFilesuffix();
                String fileFullPath = PathUtils.combinePath(baseUrl, generateSrcPath, generateRelativePath, fileName);

                if (FileUtils.isJavaFile(generatePolicyDetail.getGenerateFilesuffix())) {

                    params.put("package", "package " + PathUtils.toPointPath(generateRelativePath));
                    params.put("import", table.tableImports(generatePolicyDetail));

                    System.out.println(fileFullPath);
                    System.out.println(JSON.toJSONString(generatePolicyDetail));
                    System.out.println(JSON.toJSONString(detail));
                    System.out.println(JSON.toJSONString(params));
                }

                String fileContent = templateMatcher.matchStrToStr(detail.getTemplateName(), detail.getTemplateContent(), params);
                System.out.println(fileContent);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println(JSON.toJSONString(project));
    }

    @Override
    public ProjectModuleAddResponse addModule(ProjectModuleAddRequest request) {

        String maxProjCode = projectModuleMapper.maxProjCode();
        if (StringUtils.isEmpty(maxProjCode)) {
            request.setModuleCode(IdUtils.combineSeriaNo("MODULE", 1, 10));
        } else {
            request.setModuleCode(IdUtils.combineSeriaNo("MODULE", Integer.parseInt(maxProjCode.substring("MODULE".length())) + 1, 10));
        }

        projectModuleMapper.add(request);
        return ProjectModuleAddResponse.success();
    }

    @Override
    public ProjModulesListResponse projModulesList(ProjModulesListRequest request) {
        List<ProjectModule> projectModules = projectModuleMapper.moduleListByProjectCode(request.getProjectCode());
        return ProjModulesListResponse.success(projectModules);
    }

    @Override
    public ProjectModuleUpdResponse updModule(ProjectModuleUpdRequest request) {
        projectModuleMapper.update(request);
        return ProjectModuleUpdResponse.success();
    }

    @Override
    public ProjectModuleDelResponse delModule(ProjectModuleDelRequest request) {
        projectModuleMapper.delete(request);
        return ProjectModuleDelResponse.success();
    }

    @Override
    public ProjectModuleComponentAddResponse addComponent(ProjectComponentAddRequest request) {
        String maxCode = projectModuleComponentMapper.maxCode();
        if (StringUtils.isEmpty(maxCode)) {
            request.setComponentCode(IdUtils.combineSeriaNo("COMPONENT", 1, 10));
        } else {
            request.setComponentCode(IdUtils.combineSeriaNo("COMPONENT", Integer.parseInt(maxCode.substring("COMPONENT".length())) + 1, 10));
        }
        projectModuleComponentMapper.add(request);
        return ProjectModuleComponentAddResponse.success();
    }

    @Override
    public ProjectModuleComponentUpdResponse updComponent(ProjectComponentUpdRequest request) {
        projectModuleComponentMapper.update(request);
        return ProjectModuleComponentUpdResponse.success();
    }

    @Override
    public ProjectModuleComponentDelResponse delComponent(ProjectComponentDelRequest request) {
        projectModuleComponentMapper.delete(request);
        return ProjectModuleComponentDelResponse.success();
    }

    @Override
    public ProjectModuleComponentListResponse projComponentList(ProjectComponentListRequest request) {
        List<ProjectComponent> projectModuleComponents = projectModuleComponentMapper.listByModuleCode(request.getModuleCode());
        return ProjectModuleComponentListResponse.success(projectModuleComponents);
    }

    @Override
    public ProjectModuleComponentRelyTreeListResponse projComponentRelyTreeList(ProjectComponentListRequest request) {
        List<ProjectComponent> projectModuleComponents = projectModuleComponentMapper.listByModuleCode(request.getModuleCode());

        List<ProjectComponentRelyTree> treeList = ProjectComponentRelyTree.treeList(projectModuleComponents);

        return ProjectModuleComponentRelyTreeListResponse.success(treeList);
    }
}
