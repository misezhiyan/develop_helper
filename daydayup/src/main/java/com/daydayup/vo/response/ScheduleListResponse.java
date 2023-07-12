package com.daydayup.vo.response;

import com.daydayup.entity.Schedule;
import com.daydayup.entity.Student;
import com.daydayup.enums.ResMsg;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
* @discription 排课表
* @author kimmy
* @date ${date}
*/
@Component
@Data
public class ScheduleListResponse extends BaseResponse {

    private List<Schedule> list;

    public static ScheduleListResponse success(List<Schedule> list) {
        ScheduleListResponse response = response(ResMsg.SUCCESS);
        response.setList(list);
        return response;
    }

    public static ScheduleListResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static ScheduleListResponse response(ResMsg resMsg) {
        ScheduleListResponse response = new ScheduleListResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
