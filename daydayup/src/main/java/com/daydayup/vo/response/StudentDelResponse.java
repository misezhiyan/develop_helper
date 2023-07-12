package com.daydayup.vo.response;

import com.daydayup.enums.ResMsg;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
* @discription 
* @author kimmy
* @date ${date}
*/
@Component
@Data
public class StudentDelResponse extends BaseResponse {

    public static StudentDelResponse success() {
        StudentDelResponse response = response(ResMsg.SUCCESS);
        return response;
    }

    public static StudentDelResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static StudentDelResponse response(ResMsg resMsg) {
        StudentDelResponse response = new StudentDelResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
