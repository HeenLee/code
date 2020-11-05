package com.exercise.io;


/*
 *字节输入流
 * */

import java.io.FileInputStream;
import java.io.IOException;

public class Demo00InputStream {
    public static void main(String[] args) throws IOException {
        //demo1 读取一个字节
//        FileInputStream fis = new FileInputStream("conf/a.txt");
//        System.out.println(fis.read());  //97 a
//        System.out.println(fis.read());  //98 b
//        System.out.println(fis.read());  //99 c
//        System.out.println(fis.read());  // -1
//        System.out.println(fis.read());  // -1

        //以上可以使用循环读取
/*        FileInputStream fis = new FileInputStream("conf/a.txt");
        int len = 0;
        while((len=fis.read()) != -1){
            System.out.println((char)len);
        }*/

        //demo2 读取多个字节
/*        FileInputStream fis = new FileInputStream("conf/a.txt");
        byte[] bytes = new byte[1024]; //创建缓冲区，一次读取1024字节
        int len = fis.read(bytes);  //读取的有效字节个数
        System.out.println(len);
        System.out.println(Arrays.toString(bytes));
        fis.close();*/
        //使用循环读取
        FileInputStream fis = new FileInputStream("conf/a.txt");
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len=fis.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));  //转有效的字节数
        }
    }

}
