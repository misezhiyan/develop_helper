package com.daydayup.vo.response;

import com.daydayup.entity.Schedule;
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
public class ScheduleInfoListResponse extends BaseResponse {

    private List<ScheduleInfo> list;

    public static ScheduleInfoListResponse success(List<ScheduleInfo> list) {
        ScheduleInfoListResponse response = response(ResMsg.SUCCESS);
        response.setList(list);
        return response;
    }

    public static ScheduleInfoListResponse fail() {
        return response(ResMsg.FAIL);
    }

    public static ScheduleInfoListResponse response(ResMsg resMsg) {
        ScheduleInfoListResponse response = new ScheduleInfoListResponse();
        response.setResCode(resMsg.getCode());
        response.setResMsg(resMsg.getMessage());
        return response;
    }
}
