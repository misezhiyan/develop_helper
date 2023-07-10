package com.daydayup.controller;

import com.daydayup.service.TeacherService;
import com.daydayup.vo.request.TeacherAddRequest;
import com.daydayup.vo.request.TeacherListRequest;
import com.daydayup.vo.response.TeacherAddResponse;
import com.daydayup.vo.response.TeacherListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @discription 师资
 * @author kimmy
 * @date ${date}
 */
@RequestMapping("/teacher")
@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/add")
    public TeacherAddResponse add(@RequestBody TeacherAddRequest request) {

        return teacherService.add(request);
    }

    @RequestMapping("/list")
    public TeacherListResponse list(@RequestBody TeacherListRequest request) {

        return teacherService.list(request);
    }
}
