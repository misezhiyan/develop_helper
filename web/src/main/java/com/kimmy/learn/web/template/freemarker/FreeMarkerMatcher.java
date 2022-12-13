package com.kimmy.learn.web.template.freemarker;

import com.kimmy.learn.web.entity.domains.template.TemplateParams;
import com.kimmy.learn.web.template.TemplateMatcher;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

@Component
public class FreeMarkerMatcher implements TemplateMatcher {

    @Override
    public String matchStrToStr(String tempname, String content, TemplateParams dataMap) throws IOException, TemplateException {

        // Configuration configuration = new Configuration();
        // configuration.setNumberFormat("#");
        // configuration.setTemplateLoader(stringLoader);

        StringWriter stringWriter = new StringWriter();
        Template template = new Template(tempname, new StringReader(content));
        template.process(dataMap, stringWriter);
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        stringLoader.putTemplate(tempname, content);
        return stringWriter.toString();
    }
}
