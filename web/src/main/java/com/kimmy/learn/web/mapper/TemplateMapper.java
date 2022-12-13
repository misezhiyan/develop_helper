package com.kimmy.learn.web.mapper;

import com.kimmy.learn.web.controller.domain.request.template.TemplateFieldsListRequest;
import com.kimmy.learn.web.entity.db.Template;
import com.kimmy.learn.web.entity.db.TemplateField;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TemplateMapper {

    List<Template> templateList();

    int add(Template template);

    int update(Template template);

    Template detail(Integer templateId);
}
