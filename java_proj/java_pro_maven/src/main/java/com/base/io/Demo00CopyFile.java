package com.base.io;


/*
 *复制文件，通过缓冲区读写
  * */


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo00CopyFile {
    public static void main(String[] args) throws IOException {
        //复制文件
        FileInputStream fis = new FileInputStream("conf/a.png");
        FileOutputStream fos = new FileOutputStream("conf/copy.png");
        byte[] bytes = new byte[1024]; //读取的缓冲区
        int len = 0;
        while ((len=fis.read(bytes)) != -1)  {  //读取1024个字节
            fos.write(bytes,0,len);      //写入有效字节数
        }
        fos.close();
        fis.close();



        }
    }
