package com.daydayup.controller;

import com.daydayup.service.ScheduleService;
import com.daydayup.vo.request.*;
import com.daydayup.vo.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @discription 排课表
 * @author kimmy
 * @date ${date}
 */
@RequestMapping("/schedule")
@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping("/add")
    public ScheduleAddResponse add(@RequestBody ScheduleAddRequest request) {

        return scheduleService.add(request);
    }

    @RequestMapping("/list")
    public ScheduleListResponse list(@RequestBody ScheduleListRequest request) {

        return scheduleService.list(request);
    }

    @RequestMapping("/del")
    public ScheduleDelResponse del(@RequestBody ScheduleDelRequest request) {

        return scheduleService.del(request);
    }

    @RequestMapping("/infoList")
    public ScheduleInfoListResponse infoList(@RequestBody ScheduleInfoListRequest request) {

        return scheduleService.infoList(request);
    }

    @RequestMapping("/occupyList")
    public ScheduleOccupyListResponse occupyList(@RequestBody ScheduleOccupyListRequest request) {

        return scheduleService.occupyList(request);
    }

    @RequestMapping("/occupy")
    public ScheduleOccupyResponse occupy(@RequestBody ScheduleOccupyRequest request) {

        return scheduleService.occupy(request);
    }


}