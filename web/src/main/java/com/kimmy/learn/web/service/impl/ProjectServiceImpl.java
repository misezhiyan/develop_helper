package com.kimmy.learn.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.kimmy.learn.web.controller.domain.request.project.*;
import com.kimmy.learn.web.controller.domain.request.project.generatefiles.GenerateFiles;
import com.kimmy.learn.web.controller.domain.response.TableListResponse;
import com.kimmy.learn.web.controller.domain.response.project.*;
import com.kimmy.learn.web.db.connect.DynamicDbManager;
import com.kimmy.learn.web.db.connect.DynamicDbRunner;
import com.kimmy.learn.web.entity.db.*;
import com.kimmy.learn.web.entity.domains.db.ColumnPack;
import com.kimmy.learn.web.entity.domains.db.DB;
import com.kimmy.learn.web.entity.domains.db.Table;
import com.kimmy.learn.web.entity.domains.db.TablePack;
import com.kimmy.learn.web.entity.domains.generate.PolicyDetail;
import com.kimmy.learn.web.entity.domains.template.TemplateParams;
import com.kimmy.learn.web.mapper.*;
import com.kimmy.learn.web.service.ProjectService;
import com.kimmy.learn.web.template.TemplateMatcher;
import com.kimmy.learn.web.template.freemarker.FreeMarkerMatcher;
import com.kimmy.learn.web.util.FileUtils;
import com.kimmy.learn.web.util.PathUtils;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectMapper projectMapper;
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
        return ProjectListResponse.success(projectMapper.detailList());
    }

    @Override
    public ProjectAddResponse add(ProjectAddRequest request) {
        projectMapper.insert(request);
        List<ProjDbMapping> dbList = request.getDbList();
        if (!CollectionUtils.isEmpty(dbList)) {
            dbList.forEach(db -> db.setProjId(request.getId()));
            projDbMappingMapper.insertBatch(dbList);
        }
        return ProjectAddResponse.success();
    }

    @Override
    public ProjectUpdateResponse update(ProjectUpdateRequest request) {
        projectMapper.update(request);
        projDbMappingMapper.delByProj(request.getId());
        List<ProjDbMapping> dbList = request.getDbList();
        if (!CollectionUtils.isEmpty(dbList)) {
            dbList.forEach(db -> db.setProjId(request.getId()));
            projDbMappingMapper.insertBatch(dbList);
        }
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
                String fileFullPath = PathUtils.combinePath(baseUrl,generateSrcPath, generateRelativePath, fileName);

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
}
