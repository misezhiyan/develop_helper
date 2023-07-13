package com.daydayup.vo.response;

import com.daydayup.entity.Schedule;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @discription 排课表
 * @author kimmy
 * @date ${date}
 */
@Data
@Component
public class ScheduleOccupy extends Schedule {

    private String name;

    @JsonFormat(pattern = "yyyyMMdd")
    private Date scheduleDate;

    private String status;
}
