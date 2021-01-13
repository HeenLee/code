package com.base.io.对象的反序列化流;

import com.base.io.Person;

import java.io.*;

public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream oos = new ObjectInputStream(new FileInputStream("d:/person.txt"));
        Object o = oos.readObject();
        Person p = (Person)o;
        System.out.println(p);
        System.out.println(p.getName() + " " + p.getAge());
    }
}
