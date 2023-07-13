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
public class ScheduleOccupyResponse extends BaseResponse {

    public static ScheduleOccupyResponse success() {
        return response(ResMsg.SUCCESS, null);
    }

    public static ScheduleOccupyResponse fail(String failMsg) {
        return response(ResMsg.FAIL, failMsg);
    }

    public static ScheduleOccupyResponse response(ResMsg resMsg, String failMsg) {
        ScheduleOccupyResponse response = new ScheduleOccupyResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        if (ResMsg.SUCCESS != resMsg) {
            response.setResMsg(failMsg);
        }
        return response;
    }
}
