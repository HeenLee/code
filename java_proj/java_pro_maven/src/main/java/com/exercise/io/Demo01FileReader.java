package com.exercise.io;


import java.io.FileReader;
import java.io.IOException;

public class Demo01FileReader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("conf/hello.txt");
/*        int len = 0;
        while((len=fr.read()) != -1){
            System.out.println((char)len);
        }
        fr.close();*/

        char[] cs = new char[1024]; //存储读取到的多个字符
        int len = 0;                //记录每次读取的有效字符个数
        while((len=fr.read(cs)) != -1){
            System.out.println(new String(cs,0,len));
        }
        fr.close();
    }
}
