package com.base.异常;

public class DemoException  {
    public static void main(String[] args) {
        runtime_method();

        method();

    }

    private static void method() {
        try {
            throw new Exception("编译异常，必须处理");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runtime_method(){
        throw new RuntimeException("运行时出错了");


    }


}
