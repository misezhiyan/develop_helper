package com.daydayup.mapper;

import java.util.List;
import com.daydayup.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 用户信息表
 * @author kimmy
 * @date ${date}
 */
@Mapper
public interface UserMapper {

	List<User> list(User user);

	int insert(User user);

	int updateByUserId(User user);

	User selectByUserId(Integer userId);

	int delByUserId(Integer userId);
}
