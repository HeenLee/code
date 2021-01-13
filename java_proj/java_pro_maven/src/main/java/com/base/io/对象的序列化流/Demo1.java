package com.base.io.对象的序列化流;

import com.base.io.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 序列化集合
 * 当我们想在文件中保存多个对象的时候
 * 可以把多个对象存储到一个集合中
 * 对集合进行序列化和反序列化
 * 分析：
 * 1.定义存储Person对象的ArrayList集合
 * 2.往集合中存储person对象
 * 3.创建一个序列化ObjectOutputStream对象
 * 4.使用ObjectOutputStream对象的writeObject对集合进行序列化
 * 5.创建反序列化ObjectInputStream对象
 * 6.使用readObject方法读取文件中的集合
 * 7.把Object类型的集合转为ArrayList类型
 * 8.遍历ArrayList集合
 * 9.释放资源
 */
public class Demo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Person> personList = new ArrayList<>();

        Person p1 = new Person("张三", 12);
        Person p2 = new Person("李四", 10);
        Person p3 = new Person("王五", 8);
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/list.txt"));
        oos.writeObject(personList);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/list.txt"));
        Object o = ois.readObject();  //Object对象是ArrayList类型
        List<Person> list = (ArrayList<Person>) o;
        for (Person person : list) {
            System.out.println(person);
        }
        ois.close();
        oos.close();

    }
}
