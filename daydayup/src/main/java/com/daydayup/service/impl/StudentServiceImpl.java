package com.daydayup.service.impl;

import com.daydayup.entity.Student;
import com.daydayup.mapper.StudentMapper;
import com.daydayup.vo.response.StudentListResponse;
import com.daydayup.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @discription
 * @author kimmy
 * @date ${date}
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public StudentListResponse list(Student student) {
        List<Student> list = studentMapper.list(student);
        return StudentListResponse.success(list);
    }
}
