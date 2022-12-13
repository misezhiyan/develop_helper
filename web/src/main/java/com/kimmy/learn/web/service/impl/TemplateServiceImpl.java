package com.kimmy.learn.web.service.impl;

import com.kimmy.learn.web.controller.domain.request.template.*;
import com.kimmy.learn.web.controller.domain.response.template.*;
import com.kimmy.learn.web.entity.db.Template;
import com.kimmy.learn.web.entity.domains.template.TemplateFieldExtend;
import com.kimmy.learn.web.entity.domains.template.TemplateParams;
import com.kimmy.learn.web.mapper.TemplateFieldMapper;
import com.kimmy.learn.web.mapper.TemplateMapper;
import com.kimmy.learn.web.service.TemplateService;
import com.kimmy.learn.web.template.freemarker.FreeMarkerMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    TemplateMapper templateMapper;
    @Autowired
    TemplateFieldMapper templateFieldMapper;
    @Autowired
    FreeMarkerMatcher freeMarkerMatcher;

    @Override
    public TemplateListResponse templateList(TemplateListRequest request) {
        return TemplateListResponse.success(templateMapper.templateList());
    }

    @Override
    public TemplateAddResponse add(TemplateAddRequest request) {
        int count = templateMapper.add(request);
        return TemplateAddResponse.success();
    }

    @Override
    public TemplateUdpResponse update(TemplateUdpRequest request) {
        int count = templateMapper.update(request);
        return TemplateUdpResponse.success();
    }

    @Override
    public TemplateFieldsListResponse templateFieldsList(TemplateFieldsListRequest request) {
        return TemplateFieldsListResponse.success(templateFieldMapper.templateFieldList(request));
    }

    @Override
    public TemplateFieldAddResponse templateFieldAdd(TemplateFieldAddRequest request) {
        templateFieldMapper.add(request);
        return TemplateFieldAddResponse.success();
    }

    @Override
    public TemplateShowResponse showTemplateResult(TemplateShowRequest request) {

        Template detail = templateMapper.detail(request.getTemplateId());
        TemplateShowResponse response = new TemplateShowResponse();

        TemplateParams templateParams = new TemplateParams();
        List<TemplateFieldExtend> fieldList = request.getFieldList();
        fieldList.forEach(field -> templateParams.put(field.getFieldName(), field.getFieldValue()));
        try {
            return response.success(freeMarkerMatcher.matchStrToStr(detail.getTemplateName(), detail.getTemplateContent(), templateParams));
        } catch (Exception e) {
            return response.fail("模板匹配异常");
        }
    }
}
