package com.kimmy.learn.web.template;

import com.kimmy.learn.web.entity.domains.template.TemplateParams;
import freemarker.template.TemplateException;

import java.io.IOException;

public interface TemplateMatcher {

    String matchStrToStr(String tempname, String content, TemplateParams dataMap) throws IOException, TemplateException;
}
