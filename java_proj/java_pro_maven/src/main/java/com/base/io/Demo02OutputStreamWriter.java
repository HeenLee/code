package com.base.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo02OutputStreamWriter {
    public static void main(String[] args) throws IOException {
/*        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("conf/utf8.txt"),"utf-8");
        osw.write("知道");
        osw.close();*/

        InputStreamReader isr = new InputStreamReader(new FileInputStream("conf/utf8.txt"),"utf-8");
        int len = 0;
        while((len = isr.read()) != -1){
            System.out.println((char)len);
        }
    }

}
