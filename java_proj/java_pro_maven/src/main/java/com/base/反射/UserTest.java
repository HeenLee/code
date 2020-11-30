package com.base.反射;

import java.io.IOException;

public class UserTest {
    public static void main(String[] args) throws IOException {
        User u = new User();
        u.load();   //将prop的内容转存到User对象中
        System.out.println(u.getName()); //这样可以通过对象访问

    }


}
