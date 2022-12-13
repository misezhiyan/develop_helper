package com.kimmy.learn.web.mapper;

import com.kimmy.learn.web.entity.domains.db.Column;
import com.kimmy.learn.web.entity.domains.db.Table;
import com.kimmy.learn.web.entity.domains.db.TablePack;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DbMapper {

    TablePack tableDetail(String template);

    List<Column> columnList(String tableName);

}
