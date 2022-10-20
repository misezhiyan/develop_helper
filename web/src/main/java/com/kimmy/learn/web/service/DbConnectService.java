package com.kimmy.learn.web.service;

import com.kimmy.learn.web.controller.domain.request.DbListRequest;
import com.kimmy.learn.web.controller.domain.response.ConnectResponse;
import com.kimmy.learn.web.controller.domain.response.DbListResponse;
import com.kimmy.learn.web.entity.db.DbConnectConfig;

public interface DbConnectService {

    ConnectResponse saveconnect(DbConnectConfig dbConnectConfig);

    DbListResponse getDbList(DbListRequest request);
}
