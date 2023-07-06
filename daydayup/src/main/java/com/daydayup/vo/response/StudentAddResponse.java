package com.daydayup.vo.response;

import com.daydayup.entity.Student;
import com.daydayup.enums.ResMsg;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class StudentAddResponse extends BaseResponse {

    public static StudentAddResponse success() {
        StudentAddResponse response = response(ResMsg.SUCCESS);
        return response;
    }

    public static StudentAddResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static StudentAddResponse response(ResMsg resMsg) {
        StudentAddResponse response = new StudentAddResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
