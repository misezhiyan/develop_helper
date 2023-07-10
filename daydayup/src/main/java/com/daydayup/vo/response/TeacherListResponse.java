package com.daydayup.vo.response;

import com.daydayup.entity.Teacher;
import com.daydayup.enums.ResMsg;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class TeacherListResponse extends BaseResponse {

    private List<Teacher> list;

    public static TeacherListResponse success(List<Teacher> list) {
        TeacherListResponse response = response(ResMsg.SUCCESS);
        response.setList(list);
        return response;
    }

    public static TeacherListResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static TeacherListResponse response(ResMsg resMsg) {
        TeacherListResponse response = new TeacherListResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
