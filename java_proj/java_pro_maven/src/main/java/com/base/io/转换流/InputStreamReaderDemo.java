package com.base.io.转换流;
/**
 * 字节转换流：InputStreamReader
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {
    public static void main(String[] args) throws FileNotFoundException {
        //1. 创建对象
        InputStreamReader isr = null;
        try {
//            isr = new InputStreamReader(new FileInputStream("name.txt"));
            isr = new InputStreamReader(new FileInputStream("d:/name.txt"));
            int len = 0;
           //3.循环读取，将读取的字节转为字符
            while ((len=isr.read()) != -1){
                System.out.println((char)len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
