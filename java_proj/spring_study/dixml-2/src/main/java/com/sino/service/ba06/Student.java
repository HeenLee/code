package com.sino.service.ba06;

public class Student {
    private School school;
    private String name;
    private int age;

    public Student() {
    }

    public Student(School school, String name, int age) {
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
