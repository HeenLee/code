package com.base.file;

import java.io.File;

public class DiguiDir {
    public static void main(String[] args) {
        File f = new File("D:\\conf");
        getAllFile(f);
    }

    public static void getAllFile(File dir){
        System.out.println(dir);
        for (File file : dir.listFiles()) {
            if(file.isDirectory()){
                getAllFile(file);
            }else {

                System.out.println(file);
            }

        }

    }
}
