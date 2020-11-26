package com.exercise.file;

import java.io.File;
import java.io.IOException;

public class FileCreateAndDelete {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");
        System.out.println(path);

        File f1 = new File(path,"conf/tmp.txt");
        boolean b = f1.createNewFile();
        System.out.println(b);

        //创建单级文件夹
        File f2 = new File(path, "conf/a");
        System.out.println(f2.mkdir());

        //创建多级目录
        File f3 = new File(path, "/ss/conf/a/b/c");
        System.out.println(f3.mkdirs());

        //目录不存在，创建返回false
        File f4 = new File("h:/", "/ss/conf/a/b/c");
        System.out.println(f4.mkdirs());

        System.out.println(f1.delete()  +"a");
        System.out.println(f2.delete() +"b");
        System.out.println(f3.delete() +"c");
        System.out.println(f4.delete() +"d");

    }
}
