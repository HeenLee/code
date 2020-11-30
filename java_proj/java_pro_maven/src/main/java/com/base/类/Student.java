package com.base.类;

/**
 * 类：成员变量和成员方法
 */
public class Student {
    private String name;
    private int age;
    private boolean male;  //是否为男性

    public Student(){

    }
    public Student(String name, int age, boolean male){
        this.name = name;
        this.age = age;
        this.male = male;
    }

    public void setMale(boolean male){
        this.male = male;
    }

    public boolean isMale(){
        return male;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat(){
        System.out.println("吃饭");
    }
    public void method(Student s){
        System.out.println(s.name);
    }

    public Student getStudent(){
        Student s = new Student();
        s.name = "hehe";
        return  s;
    }

    //重写toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("name=").append(this.name).append(",age=")
                .append(this.age).append(",male=").append(male).toString();
//        return JSON.toJSONString(this);  //会报栈内存溢出异常,递归调用
    }

}
