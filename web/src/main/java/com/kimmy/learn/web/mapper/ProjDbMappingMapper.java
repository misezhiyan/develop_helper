package com.kimmy.learn.web.mapper;

import com.kimmy.learn.web.entity.db.ProjDbMapping;
import com.kimmy.learn.web.entity.db.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjDbMappingMapper {

    int insertBatch(List<ProjDbMapping> list);

    int delByProj(Integer id);
}
