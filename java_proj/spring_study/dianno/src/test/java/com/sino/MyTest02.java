package com.sino;

import com.sino.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
//        Student student = (Student) context.getBean("student");
//        Student student = (Student) context.getBean("myStudent");
        Student student = (Student) context.getBean("myStudent");
        System.out.println(student);
    }
}
