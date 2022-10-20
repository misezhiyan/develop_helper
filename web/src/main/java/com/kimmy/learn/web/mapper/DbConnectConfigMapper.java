package com.kimmy.learn.web.mapper;

import com.kimmy.learn.web.entity.db.DbConnectConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DbConnectConfigMapper {

    Integer countExisted(DbConnectConfig dbConnectConfig);

    int saveconnect(DbConnectConfig dbConnectConfig);

    List<DbConnectConfig> getDbList();
}
