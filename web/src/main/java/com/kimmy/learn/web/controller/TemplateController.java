package com.kimmy.learn.web.controller;

import com.kimmy.learn.web.controller.domain.request.template.*;
import com.kimmy.learn.web.controller.domain.response.template.*;
import com.kimmy.learn.web.service.TemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    TemplateService templateService;

    @RequestMapping("/templateList")
    public TemplateListResponse templateList(@RequestBody TemplateListRequest request) {

        return templateService.templateList(request);
    }

    @RequestMapping("/add")
    public TemplateAddResponse add(@RequestBody TemplateAddRequest request) {

        return templateService.add(request);
    }

    @RequestMapping("/update")
    public TemplateUdpResponse update(@RequestBody TemplateUdpRequest request) {

        return templateService.update(request);
    }

    @RequestMapping("/templateFieldsList")
    public TemplateFieldsListResponse templateFieldsList(@RequestBody TemplateFieldsListRequest request) {

        return templateService.templateFieldsList(request);
    }

    @RequestMapping("/templateFieldAdd")
    public TemplateFieldAddResponse templateFieldAdd(@RequestBody TemplateFieldAddRequest request) {

        return templateService.templateFieldAdd(request);
    }

    @RequestMapping("/showTemplateResult")
    public TemplateShowResponse showTemplateResult(@RequestBody TemplateShowRequest request) {

        return templateService.showTemplateResult(request);
    }

}
