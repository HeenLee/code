package com.exercise.iherite;

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
