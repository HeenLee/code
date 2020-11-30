package com.base.io流;


/*
 *字节流读取字符流会乱码
 * 读取然后写入没有问题，不能取出来
 * */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo00InputStreamReadChar {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("conf/d.txt");
        FileOutputStream fos = new FileOutputStream("conf/e.txt");
        int len = 0;
        while((len=fis.read()) != -1){
//            System.out.println(len);  //读取的是字节码,取不出来。 取出来显示就有问题。 但是可以读取出来直接写进去
            fos.write(len);
        }
        fos.close();
        fis.close();
    }

}
