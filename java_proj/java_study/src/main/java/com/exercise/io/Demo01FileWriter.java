package com.exercise.io;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo01FileWriter {
    public static void main(String[] args) throws IOException {
        FileWriter fr = new FileWriter("conf/writer.txt");
        fr.write("hello");
        fr.write("你好");
        fr.write(97);
        fr.close();


    }
}

