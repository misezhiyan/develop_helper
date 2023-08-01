package com.daydayup.controller;

import com.daydayup.service.UserService;
import com.daydayup.vo.request.UserAddRequest;
import com.daydayup.vo.response.UserAddResponse;
import com.daydayup.vo.request.UserListRequest;
import com.daydayup.vo.response.UserListResponse;
import com.daydayup.vo.request.UserDelRequest;
import com.daydayup.vo.response.UserDelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @discription 用户信息表
 * @author kimmy
 * @date ${date}
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/add")
    public UserAddResponse add(@RequestBody UserAddRequest request){

        return userService.add(request);
    }


    @RequestMapping("/list")
    public UserListResponse list(@RequestBody UserListRequest request){

        return userService.list(request);
    }

    @RequestMapping("/del")
    public UserDelResponse del(@RequestBody UserDelRequest request) {

        return  userService.del(request);
    }

}
