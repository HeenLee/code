package com.exercise.object;

/**
 * 类：成员变量和成员方法
 */
public class StaticStudent {
    public static String room;
    private String name;
    private int age;

    public StaticStudent(){

    }
    public StaticStudent(String name, int age){
        this.name = name;
        this.age = age;
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


    //重写toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("name=").append(this.name).append(",age=")
                .append(this.age).toString();
//        return JSON.toJSONString(this);  //会报栈内存溢出异常,递归调用
    }

}
