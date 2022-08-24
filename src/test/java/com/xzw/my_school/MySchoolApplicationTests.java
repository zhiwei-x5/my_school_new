package com.xzw.my_school;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xzw.my_school.mapper.StudentMapper;
import com.xzw.my_school.mapper.TeacherMapper;
import com.xzw.my_school.pojo.Student;
import com.xzw.my_school.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

@SpringBootTest
class MySchoolApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;


    @Test
    void contextLoads() {
    }
    @Test
    public void testselectList(){
        studentMapper.selectList(null).forEach(System.out::println);
    }
    //添加学生
    @Test
    public void testinsertStudent(){
        try{
            //第一步，添加课程（即先添加老师），此处为自定义sql语句
            teacherMapper.addUserByClass(3,1028);
            Student student=new Student(1028,"xzw", Date.valueOf("2022-8-19"),"男");
            studentMapper.insert (student);
        }catch (Exception e){
            System.out.println("学生名字重复  或者 未分配老师，请重新输入！");
        }
    }

    //添加老师
    @Test
    public void testinsertTeacher(){
        try{
            Teacher teacher=new Teacher(4,"jq","xzw");
            teacherMapper.insert(teacher);
        }catch (Exception e){
            System.out.println("老师工号id或者名字重复，请重新输入！");
        }
    }

    //删除老师
    @Test
    public void testdeleteTeacher(){
        try{
            //mysql有触发器，当执行delete时触发删除class课程中的与老师匹配的id
            teacherMapper.delUserByTeacher(4);
        }catch (Exception e){
            System.out.println("老师工号错误或者不存在，请重新输入！");
        }
    }

    //分页
    @Test
    public void testPage() {
        //设置分页参数
        Page<Student> page = new Page<>(1, 3);
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
    }

    //按老师分页
    @Test
    public void testPageByteacher() {
        //设置分页参数
        Page<Student> page = new Page<>(1, 3);
        int tid = teacherMapper.selUserByTeacherName("李四");
        System.out.println(tid);
//        IPage<Student> list= studentMapper.selUserByAllstudent_teacher(tid);
        studentMapper.selUserByAllstudent_teacher(page,tid);

        //获取分页数据
        List<Student> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
    }
}
