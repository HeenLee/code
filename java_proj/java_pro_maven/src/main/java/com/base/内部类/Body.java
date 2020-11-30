package com.base.内部类;

/**
 * 成员内部类
 * 格式：
 * 修饰符 class 类名称{
 *      修饰符 class 内部类名称{}
 * }
 * 内部类使用外部类的内容，随意访问。 外部类用内部的内容，需要内部类对象
 *
 */
public class Body {  //外部类


    public class Heart{            //成员内部类
        public void beat(){
            System.out.println("心脏跳动");
        }

    }
    //外部类成员变量
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //外部类的方法
    public void meth(){
        System.out.println("外部类的方法");
        new Heart().beat();  //外部类方法间接访问内部类方法
    }
}
