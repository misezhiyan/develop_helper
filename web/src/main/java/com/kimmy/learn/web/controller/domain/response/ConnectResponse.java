package com.kimmy.learn.web.controller.domain.response;

import com.kimmy.learn.web.controller.domain.BaseResponse;
import com.kimmy.learn.web.enums.ResMsg;
import org.springframework.stereotype.Component;

@Component
public class ConnectResponse extends BaseResponse {

    public static ConnectResponse success() {
        return response(ResMsg.SUCCESS);
    }

    public static ConnectResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static ConnectResponse response(ResMsg resMsg) {
        ConnectResponse response = new ConnectResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
