package com.exercise.neibulei;

/**
 * 匿名内部类
 */
public class MyInterfaceImp {
    public static void main(String[] args) {
        MyInterface my = new MyInterface(){

            @Override
            public void method() {
                System.out.println("匿名内部类");
            }
        };
        my.method();
    }
}
