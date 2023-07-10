package com.daydayup.mapper;

import java.util.List;
import com.daydayup.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 师资
 * @author kimmy
 * @date ${date}
 */
@Mapper
public interface TeacherMapper {

	List<Teacher> list(Teacher teacher);

	int insert(Teacher teacher);

	int updateById(Teacher teacher);

	Teacher selectById(Integer id);

	int delById(Integer id);
}
