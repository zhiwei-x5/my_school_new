package com.xzw.my_school.service.impl;

import com.xzw.my_school.mapper.TeacherMapper;
import com.xzw.my_school.pojo.Teacher;
import com.xzw.my_school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    //添加老师
    @Override
    public void addTeacher(Teacher teacher) {
        try{
            teacherMapper.insert(teacher);
        }catch (Exception e){
            System.out.println("老师工号id或者名字重复，请重新输入！");
        }
    }
    //删除老师
    @Override
    public void delTeacher(String name) {
        try{
            int tid=teacherMapper.selUserByTeacherName(name);
            //mysql有触发器，当执行delete时触发删除class课程中的与老师匹配的id
            teacherMapper.delUserByTeacher(tid);
        }catch (Exception e){
            System.out.println("老师工号错误或者不存在，请重新输入！");
        }
    }
}
