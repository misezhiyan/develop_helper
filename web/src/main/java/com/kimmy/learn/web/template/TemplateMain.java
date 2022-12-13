package com.kimmy.learn.web.template;

import com.kimmy.learn.web.entity.domains.db.Table;
import com.kimmy.learn.web.entity.domains.template.TemplateParams;
import com.kimmy.learn.web.template.freemarker.FreeMarkerMatcher;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TemplateMain {

    public static void main(String[] args) throws IOException, TemplateException {

        matchFreeMarker();
    }

    private static void matchFreeMarker() throws IOException, TemplateException {

        TemplateMatcher templateMatcher = new FreeMarkerMatcher();

        String tempname = "test";
        String content = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> <!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\"> <mapper namespace=\"${dbTableEntity.mapperClassFullName}\"> <resultMap id=\"BaseResultMap\" type=\"${dbTableEntity.entityClassFullName}\"> <#list dbTableEntity.fieldList as field> <#if field.isPrimary> <id column=\"${field.dbName}\" property=\"${field.className}\" jdbcType=\"${field.jdbcType}\"/> <#else> <result column=\"${field.dbName}\" property=\"${field.className}\" jdbcType=\"${field.jdbcType}\"/> </#if> </#list> </resultMap> <sql id=\"BaseColumns\"> <#list dbTableEntity.fieldList as field> ${field.dbName}<#if !user_has_next>,</#if> </#list> </sql> </mapper>";
        TemplateParams params = new TemplateParams();

        Table table = new Table();

        params.put("table", table);


        String result = templateMatcher.matchStrToStr(tempname, content, params);


        // System.out.println(content);
    }

}
