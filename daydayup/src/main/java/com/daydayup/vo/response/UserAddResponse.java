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
public class UserAddResponse extends BaseResponse {

    public static UserAddResponse success() {
        UserAddResponse response = response(ResMsg.SUCCESS);
        return response;
    }

    public static UserAddResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static UserAddResponse response(ResMsg resMsg) {
        UserAddResponse response = new UserAddResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
