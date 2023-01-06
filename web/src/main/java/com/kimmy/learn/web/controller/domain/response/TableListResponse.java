package com.kimmy.learn.web.controller.domain.response;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import com.kimmy.learn.web.entity.db.DbConnectConfig;
import com.kimmy.learn.web.entity.domains.db.Table;
import com.kimmy.learn.web.enums.ResMsg;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TableListResponse extends BaseResponse {

    private List<Table> list;

    public List<Table> getList() {
        return list;
    }

    public void setList(List<Table> list) {
        this.list = list;
    }

    public static TableListResponse success(List<Table> list) {
        TableListResponse response = response(ResMsg.SUCCESS);
        response.setList(list);
        return response;
    }

    public static TableListResponse fail(ResMsg msg) {
        return response(msg);
    }

    public static TableListResponse response(ResMsg resMsg) {
        TableListResponse response = new TableListResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
