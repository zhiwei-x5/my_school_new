package com.xzw.my_school.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xzw.my_school.pojo.Student;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper extends BaseMapper<Student> {

    IPage<Student> selUserByAllstudent_teacher(IPage<Student> page, Integer tid);
}