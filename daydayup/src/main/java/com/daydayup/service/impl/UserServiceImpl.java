package com.daydayup.service.impl;

import com.daydayup.entity.User;
import com.daydayup.mapper.UserMapper;
import com.daydayup.service.UserService;
import com.daydayup.vo.response.UserAddResponse;
import com.daydayup.vo.response.UserListResponse;
import com.daydayup.vo.response.UserDelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @discription 用户信息表
 * @author kimmy
 * @date ${date}
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserAddResponse add(User user) {
        userMapper.insert(user);
        return UserAddResponse.success();
    }

    @Override
    public UserListResponse list(User user) {

        return UserListResponse.success(userMapper.list(user));
    }

    @Override
    public UserDelResponse del(User user) {
        userMapper.delByUserId(user);
        return UserDelResponse.success();
    }

}
