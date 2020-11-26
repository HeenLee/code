package com.exercise.file;

import java.io.File;

public class BianliDir {
    public static void main(String[] args) {
        File file = new File("d:/work");
        String[] files = file.list();
        for (String subFile : files) {
            System.out.print(subFile + ",");
        }

        System.out.println("----------------------");

        File[] fileList = file.listFiles();
        for (File subFile : fileList) {
            System.out.print(subFile + ",");

        }

    }
}
