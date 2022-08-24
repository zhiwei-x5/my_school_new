package com.xzw.my_school.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzw.my_school.pojo.Student;

public interface StudentService {
    void addStudent(Student student,Integer tid);

    Page<Student> selStudent(Integer pageNum, Integer pageSize);
    Page<Student> selStudentByTeacher(Integer pageNum, Integer pageSize, String name);

}
