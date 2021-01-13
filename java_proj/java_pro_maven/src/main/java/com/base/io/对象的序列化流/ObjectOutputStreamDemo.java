package com.base.io.对象的序列化流;

import com.base.io.Person;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/person.txt"));
        Person p = new Person("张三",12);
        Person p1 = new Person("赵四",10);
        oos.writeObject(p);
        oos.writeObject(p1);
        oos.close();

    }
}
