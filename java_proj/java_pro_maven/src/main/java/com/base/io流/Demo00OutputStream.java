package com.base.io流;


/*  写数据的原理（内存--》硬盘）
 *java程序-- JVM(java虚拟机)---os操作系统---os调用写数据的方法---把数据写入到文件中
 *字节输出流的使用步骤：
 * 1.创建对象
 * 2.使用write方法
 * 3.释放资源
 *字节输出流
 * */

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo00OutputStream {
    public static void main(String[] args) throws IOException {
        //demo1
        FileOutputStream fos = new FileOutputStream("conf/a.txt");
        fos.write(97);
        fos.close();
        //demo2
/*        FileOutputStream fos = new FileOutputStream("conf/b.txt");
        byte[] b = {98,99,100};
        fos.write(b);
        fos.close();*/
        //demo3
/*        FileOutputStream fos = new FileOutputStream("conf/c.txt");
        byte[] b = {98,99,100,101,102};
        fos.write(b,2,2);
        fos.close();*/
    }

}
