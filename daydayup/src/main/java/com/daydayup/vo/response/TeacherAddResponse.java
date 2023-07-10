package com.daydayup.vo.response;

import com.daydayup.enums.ResMsg;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TeacherAddResponse extends BaseResponse {

    public static TeacherAddResponse success() {
        TeacherAddResponse response = response(ResMsg.SUCCESS);
        return response;
    }

    public static TeacherAddResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static TeacherAddResponse response(ResMsg resMsg) {
        TeacherAddResponse response = new TeacherAddResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
