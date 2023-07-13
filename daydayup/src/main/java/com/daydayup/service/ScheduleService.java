package com.daydayup.service;

import com.daydayup.entity.Schedule;
import com.daydayup.vo.request.ScheduleInfoListRequest;
import com.daydayup.vo.request.ScheduleOccupyListRequest;
import com.daydayup.vo.request.ScheduleOccupyRequest;
import com.daydayup.vo.response.*;

/**
 * @discription 排课表
 * @author kimmy
 * @date ${date}
 */
public interface ScheduleService {

    ScheduleAddResponse add(Schedule schedule);

    ScheduleListResponse list(Schedule schedule);

    ScheduleDelResponse del(Schedule schedule);

    ScheduleInfoListResponse infoList(ScheduleInfoListRequest request);

    ScheduleOccupyListResponse occupyList(ScheduleOccupyListRequest request);

    ScheduleOccupyResponse occupy(ScheduleOccupyRequest request);
}