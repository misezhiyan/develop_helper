package com.daydayup.vo.response;

import com.daydayup.enums.ResMsg;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
* @discription 排课表
* @author kimmy
* @date ${date}
*/
@Component
@Data
public class ScheduleAddResponse extends BaseResponse {

    public static ScheduleAddResponse success() {
        ScheduleAddResponse response = response(ResMsg.SUCCESS);
        return response;
    }

    public static ScheduleAddResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static ScheduleAddResponse response(ResMsg resMsg) {
        ScheduleAddResponse response = new ScheduleAddResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
