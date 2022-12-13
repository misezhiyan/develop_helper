package com.kimmy.learn.template;

import com.alibaba.fastjson.JSONObject;
import com.kimmy.learn.template.runner.TemplateRunner;
import com.kimmy.learn.template.utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TemplateMain {

    public static void main(String[] args) throws IOException {

        matchSimpleTemplate();
        // matchTemplate();
    }

    private static void matchSimpleTemplate() throws IOException {

        String filePath = "D:\\workspaces\\workspace_spring\\develop_helper\\Template\\src\\main\\resources\\mapperXml.template";
        String templateContent = FileUtils.readFileAsString(filePath);
        System.out.println("原文本");
        System.out.println(templateContent);

        TemplateRunner.analyzeSimpleTemplate(templateContent);


        // JSONObject paramJson = new JSONObject();
        // paramJson.put("cc", "com.kimmy.learn.666");
        // List<String> keyList = new ArrayList<>();
        // keyList.add("cc");
        // String result = TemplateRunner.matchSimpleTemplate(templateContent, keyList, paramJson);
        //
        //
        //
        // System.out.println(result);

    }

}
