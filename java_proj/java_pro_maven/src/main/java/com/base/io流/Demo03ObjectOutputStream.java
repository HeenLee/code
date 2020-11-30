package com.base.io流;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
序列化礼
 */
public class Demo03ObjectOutputStream {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("conf/person.txt"));
        os.writeObject(new Person("ha",2));
    }

}
