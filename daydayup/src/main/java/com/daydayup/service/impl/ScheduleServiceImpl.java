package com.daydayup.service.impl;

import com.daydayup.entity.Schedule;
import com.daydayup.mapper.ScheduleMapper;
import com.daydayup.service.ScheduleService;
import com.daydayup.vo.response.ScheduleAddResponse;
import com.daydayup.vo.response.ScheduleListResponse;
import com.daydayup.vo.response.ScheduleDelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @discription 排课表
 * @author kimmy
 * @date ${date}
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleMapper scheduleMapper;

    @Override
    public ScheduleAddResponse add(Schedule schedule) {
        scheduleMapper.insert(schedule);
        return ScheduleAddResponse.success();
    }

    @Override
    public ScheduleListResponse list(Schedule schedule) {

        return ScheduleListResponse.success(scheduleMapper.list(schedule));
    }

    @Override
    public ScheduleDelResponse del(Schedule schedule) {
        scheduleMapper.delById(schedule.getId());
        return ScheduleDelResponse.success();
    }

}
