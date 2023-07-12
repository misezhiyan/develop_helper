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
public class ScheduleDelResponse extends BaseResponse {

    public static ScheduleDelResponse success() {
        ScheduleDelResponse response = response(ResMsg.SUCCESS);
        return response;
    }

    public static ScheduleDelResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static ScheduleDelResponse response(ResMsg resMsg) {
        ScheduleDelResponse response = new ScheduleDelResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
