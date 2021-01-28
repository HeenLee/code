package com.sino.ba02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("myStudent")
public class Student {
    /**
     *  @Value:简单类型赋值
     *      属性： value 是String类型的，表示简单类型的属性值
     *      位置：1.在属性定义的上面，无需set方法，推荐使用
     *           2.在set方法的上面
     */
    @Value("张飞")
    private String name;
    @Value(value="29")
    private int age;


    public Student() {
        System.out.println("Student无参构造");
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Value("张思")
    public void setName(String name) {
        this.name = name;
    }
    @Value("30")
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
