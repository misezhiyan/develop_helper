package com.daydayup.service;

import com.daydayup.entity.Student;
import com.daydayup.vo.response.StudentAddResponse;
import com.daydayup.vo.response.StudentListResponse;
import com.daydayup.vo.response.StudentDelResponse;

/**
 * @discription 
 * @author kimmy
 * @date ${date}
 */
public interface StudentService {

    StudentAddResponse add(Student student);

    StudentListResponse list(Student student);

    StudentDelResponse del(Student student);
}