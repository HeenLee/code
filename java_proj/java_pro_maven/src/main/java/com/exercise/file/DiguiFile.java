package com.exercise.file;

import java.io.File;

/**
 * 搜索目录中的.java文件
 */
public class DiguiFile {
    public static void main(String[] args) {
        File f = new File("D:\\conf");
        getFile(f);

    }

    public static void getFile(File dir){
        for (File file : dir.listFiles()) {
            if(file.isFile() && file.getName().endsWith(".java")){
                System.out.println(file);
            }
            if(file.isDirectory()){
                getFile(file);
            }
        }
    }
}
