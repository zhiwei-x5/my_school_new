package com.xzw.my_school.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xzw.my_school.pojo.Student;
import com.xzw.my_school.pojo.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper extends BaseMapper<Teacher> {
    //先添加class表
    int addUserByClass(Integer tid,Integer sid);

    //删除老师
    int delUserByTeacher(Integer tid);

    //查询
    int selUserByTeacherName(String name);

}
