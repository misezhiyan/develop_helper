package com.daydayup.controller;

import com.daydayup.service.StudentService;
import com.daydayup.vo.request.StudentAddRequest;
import com.daydayup.vo.response.StudentAddResponse;
import com.daydayup.vo.request.StudentListRequest;
import com.daydayup.vo.response.StudentListResponse;
import com.daydayup.vo.request.StudentDelRequest;
import com.daydayup.vo.response.StudentDelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @discription 
 * @author kimmy
 * @date ${date}
 */
@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/add")
    public StudentAddResponse add(@RequestBody StudentAddRequest request){

        return studentService.add(request);
    }


    @RequestMapping("/list")
    public StudentListResponse list(@RequestBody StudentListRequest request){

        return studentService.list(request);
    }

    @RequestMapping("/del")
    public StudentDelResponse del(@RequestBody StudentDelRequest request) {

        return  studentService.del(request);
    }

}
