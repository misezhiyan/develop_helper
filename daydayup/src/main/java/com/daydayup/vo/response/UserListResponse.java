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
public class UserListResponse extends BaseResponse {

    public static UserListResponse success() {
        UserListResponse response = response(ResMsg.SUCCESS);
        return response;
    }

    public static UserListResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static UserListResponse response(ResMsg resMsg) {
        UserListResponse response = new UserListResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
