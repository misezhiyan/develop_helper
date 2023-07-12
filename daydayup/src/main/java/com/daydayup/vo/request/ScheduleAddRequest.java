package com.daydayup.vo.request;

import com.daydayup.entity.Schedule;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @discription 排课表
 * @author kimmy
 * @date ${date}
 */
@Data
@Component
public class ScheduleAddRequest extends Schedule {

    @JsonFormat(pattern = "yyyyMMdd")
    private Date scheduleDate;

}
