package com.kimmy.learn.web.mapper;

import com.kimmy.learn.web.entity.db.TemplateField;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TemplateFieldMapper {

    List<TemplateField> templateFieldList(TemplateField templateField);

    int add(TemplateField templateField);
}
