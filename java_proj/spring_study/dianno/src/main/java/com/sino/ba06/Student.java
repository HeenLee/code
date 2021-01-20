package com.sino.ba06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("myStudent")
public class Student {

    @Value("张敏")
    private String name;
    @Value("18")
    private int age;

    /**
     * 引用类型
     * @Resource 来自jdk中的注解，spring框架提供了
     * 对这个注解的功能支持，可以使用她给引用类型赋值。使用的也是自动注入
     * 支持byName,byType   默认byName
     * 位置：1.在属性定义的上面，无需set方法，推荐使用
     *      2.在set方法的上面
     */
    //默认是byName，先使用byName自动注入，如果byName赋值失败，再使用byType
    @Resource
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
