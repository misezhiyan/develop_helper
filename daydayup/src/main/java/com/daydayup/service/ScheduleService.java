package com.daydayup.service;

import com.daydayup.entity.Schedule;
import com.daydayup.vo.response.ScheduleAddResponse;
import com.daydayup.vo.response.ScheduleListResponse;
import com.daydayup.vo.response.ScheduleDelResponse;

/**
 * @discription 排课表
 * @author kimmy
 * @date ${date}
 */
public interface ScheduleService {

    ScheduleAddResponse add(Schedule schedule);

    ScheduleListResponse list(Schedule schedule);

    ScheduleDelResponse del(Schedule schedule);
}