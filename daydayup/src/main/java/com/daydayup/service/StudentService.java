package com.daydayup.service;

import com.daydayup.entity.Student;
import com.daydayup.vo.response.StudentListResponse;

/**
 * @discription 
 * @author kimmy
 * @date ${date}
 */
public interface StudentService {

    StudentListResponse list(Student student);
}
