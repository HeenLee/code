package com.sino.ba03.impl;

import com.sino.ba03.SomeService;
import com.sino.ba03.Student;

//目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        //给doSome方法增加一个功能，在doSome()执行之前，输出方法的执行时间
        System.out.println("---目标方法doSome()----");

    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("===目标方法doOther()===");
        return "abcd";
    }

    @Override
    public Student doOther2(String name, Integer age) {
        Student student = new Student();
        student.setAge(23);
        student.setName("wangwu");
        return student;
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("==业务方法doFirst====");
        return "doFirst";
    }
}
