package com.daydayup.vo.response;

import com.daydayup.entity.Schedule;
import com.daydayup.enums.ResMsg;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @discription 排课表
 * @author kimmy
 * @date ${date}
 */
@Data
@Component
public class ScheduleInfo extends Schedule {

    private String name;
    @JsonFormat(pattern = "yyyyMMdd")
    private Date scheduleDate;
}
