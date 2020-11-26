package com.exercise.file;

import java.io.File;

public class FileMethod{
    public static void main(String[] args) {
        File f1 = new File("d:/a/b/c/a.txt");  //文件路径
        File f2 = new File("com");     //目录路径

        /**
         * 获取功能
         */
        System.out.println(f1.getAbsolutePath()); //文件路径 d:\a\b\c\a.txt
        System.out.println(f2.getAbsolutePath());  //D:\study\code\java_proj\java_pro_maven\com

        System.out.println(f1.getPath());    //给的绝对路径，返回绝对的
        System.out.println(f2.getPath());    //给的相对路径，返回相对的

        System.out.println(f1.getName());   //只返回文件名称
        System.out.println(f2.getName());   //只返回目录名称

        System.out.println(f1.length());     //文件不存在，大小为0
        System.out.println(f2.length());    //文件夹没有大小，返回0


        /**
         * 判断功能
         */
        System.out.println(f1.exists());
        System.out.println(f2.exists());

        System.out.println(f1.isDirectory()); //不是实际存在，返回false。用前先判断
        System.out.println(f2.isDirectory());

        if(f1.exists()){

        }
        System.out.println(f1.isFile());   //不是实际存在，返回false
        System.out.println(f2.isFile());

        File f3 = new File("d:/");
        System.out.println(f3.isDirectory());
        System.out.println(f3.isFile());

    }

}