package com.kimmy.learn.web.service.impl;

import com.kimmy.learn.web.controller.domain.request.DbListRequest;
import com.kimmy.learn.web.controller.domain.response.ConnectResponse;
import com.kimmy.learn.web.controller.domain.response.DbListResponse;
import com.kimmy.learn.web.entity.db.DbConnectConfig;
import com.kimmy.learn.web.mapper.DbConnectConfigMapper;
import com.kimmy.learn.web.service.DbConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbConnectServiceImpl implements DbConnectService {

    @Autowired
    DbConnectConfigMapper dbConnectConfigMapper;

    @Override
    public ConnectResponse saveconnect(DbConnectConfig dbConnectConfig) {
        if (dbConnectConfigMapper.countExisted(dbConnectConfig) > 1) {
            return ConnectResponse.fail();
        }
        dbConnectConfigMapper.saveconnect(dbConnectConfig);
        return ConnectResponse.success();
    }

    @Override
    public DbListResponse getDbList(DbListRequest request) {

        return DbListResponse.success(dbConnectConfigMapper.getDbList());
    }

}
