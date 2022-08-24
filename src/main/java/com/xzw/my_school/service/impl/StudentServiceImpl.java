package com.xzw.my_school.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzw.my_school.mapper.StudentMapper;
import com.xzw.my_school.mapper.TeacherMapper;
import com.xzw.my_school.pojo.Student;
import com.xzw.my_school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    //添加学生
    @Override
    public void addStudent(Student student,Integer tid) {
        try{
            //第一步，添加课程（即先添加老师），此处为自定义sql语句
            teacherMapper.addUserByClass(tid,student.getSNo());
            studentMapper.insert (student);
        }catch (Exception e){
            System.out.println("学生名字重复  或者 未分配老师 或者老师id不存在，请重新输入！");
        }
    }
    @Override
    public Page<Student> selStudent(Integer pageNum, Integer pageSize) {
        //设置分页参数
        Page<Student> page = new Page<>(pageNum, pageSize);
        studentMapper.selectPage(page, null);
        //获取分页数据
        List<Student> list = page.getRecords();

        list.forEach(System.out::println);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
        return page;
    }

    @Override
    public Page<Student> selStudentByTeacher(Integer pageNum, Integer pageSize, String name) {
        //设置分页参数
        Page<Student> page = new Page<>(pageNum, pageSize);
        int tid = teacherMapper.selUserByTeacherName(name);
        System.out.println(tid);
//        IPage<Student> list= studentMapper.selUserByAllstudent_teacher(tid);
        studentMapper.selUserByAllstudent_teacher(page, tid);

        //获取分页数据
        List<Student> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());

        return page;
    }
}
