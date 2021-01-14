package com.sino.service;

import com.sino.service.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class MyTest03 {
    @Test
    public void test01(){
        String config = "ba03/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        Student student = (Student) context.getBean("myStudent");
        System.out.println(student);
    }

    @Test
    public void test02(){
        String config = "ba03/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        Student student = (Student) context.getBean("myStudent2");
        System.out.println(student);
    }

    @Test
    public void test03(){
        String config = "ba03/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        File file = (File) context.getBean("myfile");
        System.out.println(file);
    }
}
