package com.daydayup.vo.response;

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
public class ScheduleOccupyListResponse extends BaseResponse {

    private List<ScheduleOccupy> list;

    public static ScheduleOccupyListResponse success(List<ScheduleOccupy> list) {
        ScheduleOccupyListResponse response = response(ResMsg.SUCCESS);
        response.setList(list);
        return response;
    }

    public static ScheduleOccupyListResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static ScheduleOccupyListResponse response(ResMsg resMsg) {
        ScheduleOccupyListResponse response = new ScheduleOccupyListResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
