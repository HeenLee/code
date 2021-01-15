package com.sino.ba03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myStudent")
public class Student {

    @Value("张敏")
    private String name;
    @Value("18")
    private int age;
    /**
     * 引用类型
     * @Autowired:spring框架提供的注解，实现引用类型的赋值
     * spring中通过注解给引用类型赋值，使用的是自动注入原理。支持byName byType
     * @Autowired默认使用的是byType自动注入
     *
     * 位置：1.在属性定义的上面，无需set方法，推荐使用
     *      2.在set方法的上面
     */
    //byType自动注入
    @Autowired
    private School school;

    public Student() {
        System.out.println("Student无参构造");
    }

    public Student(String name, int age, School school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
