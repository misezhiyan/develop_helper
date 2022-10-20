package com.kimmy.learn.web.controller.domain.response;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import com.kimmy.learn.web.entity.db.DbConnectConfig;
import com.kimmy.learn.web.enums.ResMsg;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbListResponse extends BaseResponse {

    private List<DbConnectConfig> list;

    public List<DbConnectConfig> getList() {
        return list;
    }

    public void setList(List<DbConnectConfig> list) {
        this.list = list;
    }

    public static DbListResponse success(List<DbConnectConfig> list) {

        DbListResponse response = response(ResMsg.SUCCESS);
        response.setList(list);
        return response;
    }

    public static DbListResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static DbListResponse response(ResMsg resMsg) {
        DbListResponse response = new DbListResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
