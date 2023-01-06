package com.kimmy.learn.web;

import com.alibaba.fastjson.JSON;
import com.kimmy.learn.web.controller.domain.request.project.generatefiles.GenerateFiles;
import com.kimmy.learn.web.service.ProjectService;
import com.kimmy.learn.web.test.TestService;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class TemplateTests {

    @Autowired
    TestService testService;
    @Autowired
    ProjectService projectService;

    @Test
    public void test() throws IOException, TemplateException {
        // testService.testFreemarker();
        String json = "{dbId: 17, dbNickName: \"数字信用测试环境\", tableName: \"infeed_credit_material\", policyId: 7, policyName: \"web全套\"}";
        GenerateFiles generateFiles = JSON.parseObject(json, GenerateFiles.class);
        projectService.generateProjTemplate(2,generateFiles);
    }

}
