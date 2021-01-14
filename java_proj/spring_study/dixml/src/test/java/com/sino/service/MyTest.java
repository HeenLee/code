package com.sino.service;

import com.sino.service.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {
    @Test
    public void test01(){
        String config = "ba01/applicationContext.xml";

        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        Student student = (Student) context.getBean("myStudent");
        System.out.println(student);
    }

    @Test
    public void test02(){
        String config = "ba01/applicationContext.xml";

        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        Date date = (Date) context.getBean("mydate");
        System.out.println(date);

    }


}
