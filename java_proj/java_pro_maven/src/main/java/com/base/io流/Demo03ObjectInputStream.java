package com.base.io流;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 反序列化流  把文件中保存的对象，以流的方式读取出来
 *
 */
public class Demo03ObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("conf/person.txt"));
        Object s = ois.readObject();
        ois.close();
        System.out.println(s);
    }
}
