package com.sino.service.ba03;

public class Student {
    private School school;
    private String name;
    private int age;

    public Student() {
        System.out.println("spring会调用类的无参构造方法创建对象");
    }


    /**
     * 有参构造
     * @param school
     * @param name
     * @param age
     */
    public Student(School school, String name, int age) {
        System.out.println("student有参构造");
        this.school = school;
        this.name = name;
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "school=" + school +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
