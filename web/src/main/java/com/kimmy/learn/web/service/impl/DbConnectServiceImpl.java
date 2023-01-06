package com.kimmy.learn.web.service.impl;

import com.alibaba.druid.DbType;
import com.kimmy.learn.web.controller.domain.request.DbListRequest;
import com.kimmy.learn.web.controller.domain.request.TableListRequest;
import com.kimmy.learn.web.controller.domain.response.ConnectResponse;
import com.kimmy.learn.web.controller.domain.response.DbListResponse;
import com.kimmy.learn.web.controller.domain.response.TableListResponse;
import com.kimmy.learn.web.db.connect.DynamicDbManager;
import com.kimmy.learn.web.db.connect.DynamicDbRunner;
import com.kimmy.learn.web.entity.db.DbConnectConfig;
import com.kimmy.learn.web.entity.domains.db.Table;
import com.kimmy.learn.web.enums.ResMsg;
import com.kimmy.learn.web.mapper.DbConnectConfigMapper;
import com.kimmy.learn.web.mapper.DbMapper;
import com.kimmy.learn.web.service.DbConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbConnectServiceImpl implements DbConnectService {

    @Autowired
    DynamicDbManager dynamicDbManager;

    @Autowired
    DbConnectConfigMapper dbConnectConfigMapper;
    @Autowired
    DbMapper dbMapper;

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

    @Override
    public TableListResponse getTableList(TableListRequest request) {

        DbConnectConfig dbConfig = dbConnectConfigMapper.getDbConfig(request.getId());
        DynamicDbRunner runner = null;
        try {
            // runner = dynamicDbManager.getRunner(1, DbType.mysql, request.getDriverClassName(), "jdbc:mysql://" + request.getDbIp() + ":" + request.getDbPort() + "/" + request.getDefaultConnectDb(), request.getDbUser(), request.getDbPwd());
            runner = dynamicDbManager.getRunner(dbConfig);
            String sql = "SELECT `TABLE_NAME` tableName, TABLE_COMMENT tableComment FROM information_schema.TABLES t WHERE TABLE_SCHEMA = '"+dbConfig.getDefaultConnectDb()+"'";
            List<Table> tables = runner.queryList(sql, Table.class);

            return TableListResponse.success(tables);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != runner) {
                runner.close();
            }
        }

        return TableListResponse.fail(ResMsg.FAIL);
    }

}
