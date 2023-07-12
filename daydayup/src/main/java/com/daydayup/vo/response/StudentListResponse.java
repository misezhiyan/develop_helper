package com.daydayup.vo.response;

import com.daydayup.entity.Student;
import com.daydayup.enums.ResMsg;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @discription 
* @author kimmy
* @date ${date}
*/
@Component
@Data
public class StudentListResponse extends BaseResponse {

    private List<Student> list;

    public static StudentListResponse success(List<Student> list) {
        StudentListResponse response = response(ResMsg.SUCCESS);
        response.setList(list);
        return response;
    }

    public static StudentListResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static StudentListResponse response(ResMsg resMsg) {
        StudentListResponse response = new StudentListResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
