package com.kimmy.learn.web.controller;

import com.alibaba.druid.DbType;
import com.kimmy.learn.web.controller.domain.request.ConnectRequest;
import com.kimmy.learn.web.controller.domain.request.DbListRequest;
import com.kimmy.learn.web.controller.domain.response.ConnectResponse;
import com.kimmy.learn.web.controller.domain.response.DbListResponse;
import com.kimmy.learn.web.db.connect.DynamicDbManager;
import com.kimmy.learn.web.db.connect.DynamicDbRunner;
import com.kimmy.learn.web.entity.db.DbConnectConfig;
import com.kimmy.learn.web.service.DbConnectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/dbconnect")
public class DbConnectController {

    @Autowired
    DynamicDbManager dynamicDbManager;
    @Autowired
    DbConnectService dbConnectService;

    /**
     * 测试链接
     * @param request
     * @return
     */
    @RequestMapping("/testconnect")
    public ConnectResponse testConnect(@RequestBody ConnectRequest request) {

        DynamicDbRunner runner = null;
        try {
            runner = dynamicDbManager.getRunner(1, DbType.mysql, request.getDriverClassName(), "jdbc:mysql://" + request.getDbIp() + ":" + request.getDbPort() + "/test", request.getDbUser(), request.getDbPwd());
            String sql = "select 1 from dual";
            Integer test = runner.queryOne(sql, Integer.class);
            if (test == 1)
                return ConnectResponse.success();
            else
                return ConnectResponse.fail();
        } catch (Exception e) {
            e.printStackTrace();
            return ConnectResponse.fail();
        } finally {
            if (null != runner) {
                runner.close();
            }
        }
        // return  testService.testDbConnect();
    }

    /**
     * 保存链接
     * @param request
     * @return
     */
    @RequestMapping("/saveconnect")
    public ConnectResponse saveconnect(@RequestBody ConnectRequest request) {
        DbConnectConfig dbConnectConfig = new DbConnectConfig();
        BeanUtils.copyProperties(request, dbConnectConfig);
        return dbConnectService.saveconnect(dbConnectConfig);
    }

    /**
     * 数据库配置列表
     * @param request
     * @return
     */
    @RequestMapping("/getDbList")
    public DbListResponse getDbList(@RequestBody DbListRequest request) {
        return dbConnectService.getDbList(request);
    }


}
