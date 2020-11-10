package com.exercise.object;

import org.junit.Test;

public class StudentTest {
    /**
     * 测试Student类
     */
    @Test
    public void test_createStu(){
        Student stu = new Student();
        stu.eat();
        stu.setName("sinosun");
        System.out.println(stu.getName());
    }

    /**
     * 测试对象类型作为入参
     */
    @Test
    public void test_obj(){
        Student s = new Student();
        s.setName("张三");
        s.method(s);
    }

    /**
     * 测试返回对象
     */
    @Test
    public void test_return_obj(){
        Student s = new Student().getStudent();
        System.out.println(s.getName());
    }

    /**
     * 返回json字符串
     */
    @Test
    public void test_return_jsonobj(){
        Student stu = new Student("wanghong",23, true);
        System.out.println(stu.toString());

    }
}
