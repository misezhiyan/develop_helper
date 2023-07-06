package com.daydayup.controller;

import com.daydayup.vo.request.StudentListRequest;
import com.daydayup.vo.response.StudentListResponse;
import com.daydayup.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 生源信息
 * @author: liyq
 * @createtime: 2023-07-06 11:22
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/list")
    public StudentListResponse list(@RequestBody StudentListRequest request){

        return studentService.list(request);
    }

}
