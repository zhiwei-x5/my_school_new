package com.xzw.my_school;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xzw.my_school.mapper")
public class MySchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySchoolApplication.class, args);
    }

}
