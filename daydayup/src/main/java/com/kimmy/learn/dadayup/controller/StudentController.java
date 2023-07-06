package com.kimmy.learn.dadayup.controller;

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

    @RequestMapping("/list")
    public ConnectResponse list(@RequestBody ConnectRequest request){

    }

}
