package com.base.io;


import java.io.File;
import java.io.IOException;

public class FileStudy {
    public static void main(String[] args) throws IOException {
        //获取当前工作目录
        String dirPath = System.getProperty("user.dir");
        //找到conf目录下的hello.txt路径
        String filepath = dirPath + File.separator + "conf" + File.separator + "hello.txt";

        File file = new File(filepath);
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getAbsoluteFile());

        String filepath1 = dirPath + File.separator + "conf" + File.separator + "abc.txt";
        File file1 = new File(filepath1);
        if(!file1.exists()){
            file1.createNewFile();
        }
    }
}
