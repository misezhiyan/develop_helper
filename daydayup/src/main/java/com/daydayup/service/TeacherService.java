package com.daydayup.service;

import com.daydayup.entity.Teacher;
import com.daydayup.vo.request.TeacherAddRequest;
import com.daydayup.vo.request.TeacherListRequest;
import com.daydayup.vo.response.TeacherAddResponse;
import com.daydayup.vo.response.TeacherListResponse;

/**
 * @discription 师资
 * @author kimmy
 * @date ${date}
 */
public interface TeacherService {

    TeacherAddResponse add(Teacher teacher);

    TeacherListResponse list(Teacher teacher);
}
