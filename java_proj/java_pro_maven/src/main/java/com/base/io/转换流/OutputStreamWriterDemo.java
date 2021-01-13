package com.base.io.转换流;

import java.io.*;

public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:/study/code/java_proj/java_pro_maven/src/main/resources/hello.txt"));
        osw.write("我是中国人");
        osw.close();

    }

}
