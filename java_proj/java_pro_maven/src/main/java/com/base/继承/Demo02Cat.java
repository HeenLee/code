package com.base.继承;

public class Demo02Cat extends Demo02Animal{
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    //子类特有方法
    public void catchMouse(){
        System.out.println("抓老鼠");
    }
}
