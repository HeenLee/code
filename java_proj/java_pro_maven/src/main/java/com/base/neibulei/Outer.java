package com.base.neibulei;

public class Outer {


    public void methodOuter(){  //外部类的成员方法
        int age = 20;
         class Inner{   //局部内部类
             int num = 10;
             public void methodInner(){
                 System.out.println(num);
                 System.out.println(age);
             }
        }
        //方法体内定义内部类对象
        Inner inner = new Inner();
        inner.methodInner();
    }
}
