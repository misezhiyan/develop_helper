package com.daydayup.mapper;

import java.util.List;
import com.daydayup.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 
 * @author kimmy
 * @date ${date}
 */
@Mapper
public interface StudentMapper {

	List<Student> list(Student student);

	int insert(Student student);

	int updateById(Student student);

	Student selectById(Integer id);

	int delById(Integer id);
}
