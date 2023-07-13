package com.daydayup.vo.request;

import com.daydayup.entity.Schedule;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @discription 排课表
 * @author kimmy
 * @date ${date}
 */
@Data
@Component
public class ScheduleOccupyRequest {
    private Integer studentId;
    private Schedule schedule;
}
