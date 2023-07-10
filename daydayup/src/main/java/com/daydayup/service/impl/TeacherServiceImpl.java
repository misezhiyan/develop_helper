package com.daydayup.service.impl;

import com.daydayup.entity.Teacher;
import com.daydayup.mapper.TeacherMapper;
import com.daydayup.service.TeacherService;
import com.daydayup.vo.request.TeacherAddRequest;
import com.daydayup.vo.request.TeacherListRequest;
import com.daydayup.vo.response.TeacherAddResponse;
import com.daydayup.vo.response.TeacherListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @discription 师资
 * @author kimmy
 * @date ${date}
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public TeacherAddResponse add(Teacher teacher) {
        teacherMapper.insert(teacher);
        return TeacherAddResponse.success();
    }

    @Override
    public TeacherListResponse list(Teacher teacher) {
        ;
        return TeacherListResponse.success(teacherMapper.list(teacher));
    }
}
