package com.daydayup.service.impl;

import com.daydayup.entity.Student;
import com.daydayup.mapper.StudentMapper;
import com.daydayup.service.StudentService;
import com.daydayup.vo.response.StudentAddResponse;
import com.daydayup.vo.response.StudentListResponse;
import com.daydayup.vo.response.StudentDelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public StudentAddResponse add(Student student) {
        studentMapper.insert(student);
        return StudentAddResponse.success();
    }

    @Override
    public StudentListResponse list(Student student) {

        return StudentListResponse.success(studentMapper.list(student));
    }

    @Override
    public StudentDelResponse del(Student student) {
        studentMapper.delById(student.getId());
        return StudentDelResponse.success();
    }

}
