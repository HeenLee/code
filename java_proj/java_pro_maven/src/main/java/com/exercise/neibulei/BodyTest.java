package com.exercise.neibulei;

public class BodyTest {
    public static void main(String[] args) {
        //1. 外部类通过方法间接访问内部类方法
        Body b = new Body();
        b.meth();

        //2. 通过创建内部类对象访问内部类方法
        Body.Heart heart= new Body().new Heart();
        heart.beat();
    }
}
