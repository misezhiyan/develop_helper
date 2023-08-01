package com.daydayup.vo.response;

import com.daydayup.enums.ResMsg;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
* @discription 用户信息表
* @author kimmy
* @date ${date}
*/
@Component
@Data
public class UserDelResponse extends BaseResponse {

    public static UserDelResponse success() {
        UserDelResponse response = response(ResMsg.SUCCESS);
        return response;
    }

    public static UserDelResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static UserDelResponse response(ResMsg resMsg) {
        UserDelResponse response = new UserDelResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
