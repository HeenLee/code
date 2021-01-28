package com.sino.ba07;

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
     * @Resource 只使用byName方式，需要增加一个属性name
     * name的值是bean的Id名称
     */
    //默认是byName，先使用byName自动注入，如果byName赋值失败，再使用byType
    @Resource(name = "mySchool")
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
