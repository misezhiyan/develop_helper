package com.daydayup.service;

import com.daydayup.entity.User;
import com.daydayup.vo.response.UserAddResponse;
import com.daydayup.vo.response.UserListResponse;
import com.daydayup.vo.response.UserDelResponse;

/**
 * @discription 用户信息表
 * @author kimmy
 * @date ${date}
 */
public interface UserService {

    UserAddResponse add(User user);

    UserListResponse list(User user);

    UserDelResponse del(User user);
}