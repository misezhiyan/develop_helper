package com.daydayup.service.impl;

import com.daydayup.entity.Schedule;
import com.daydayup.entity.ScheduleOrder;
import com.daydayup.mapper.ScheduleMapper;
import com.daydayup.mapper.ScheduleOrderMapper;
import com.daydayup.service.ScheduleService;
import com.daydayup.vo.request.ScheduleInfoListRequest;
import com.daydayup.vo.request.ScheduleOccupyListRequest;
import com.daydayup.vo.request.ScheduleOccupyRequest;
import com.daydayup.vo.response.*;
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
    @Autowired
    ScheduleOrderMapper scheduleOrderMapper;

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

    @Override
    public ScheduleInfoListResponse infoList(ScheduleInfoListRequest request) {
        return ScheduleInfoListResponse.success(scheduleMapper.infoList(request));
    }

    @Override
    public ScheduleOccupyListResponse occupyList(ScheduleOccupyListRequest request) {
        return ScheduleOccupyListResponse.success(scheduleMapper.occupyList(request));
    }

    @Override
    public ScheduleOccupyResponse occupy(ScheduleOccupyRequest request) {
        ScheduleOrder param = new ScheduleOrder();
        param.setScheduleId(request.getSchedule().getId());
        param.setStudentId(request.getStudentId());

        ScheduleOrder result = scheduleOrderMapper.select(param);
        if (result != null) {
            if (result.getStudentId() != request.getStudentId()) {
                return ScheduleOccupyResponse.fail("课程已被其它用户占用");
            }
            scheduleOrderMapper.delById(result.getId());
        } else
            scheduleOrderMapper.insert(param);
        return ScheduleOccupyResponse.success();
    }

}
