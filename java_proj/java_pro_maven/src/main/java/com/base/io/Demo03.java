package com.base.io;

import java.io.*;
import java.util.ArrayList;

/**
 * 联系 序列化集合
 * 当我们在文件中保存多个对象，可以把多个对象存储到一个集合
 * 对集合进行序列化和反序列化
 * 分析：
 *  1.定义存储Person对象的ArrayList
 *  2.往集合中存储Persion
 *  3.创建一个序列化流ObjectOutputStream对象
 *  4.使用ObjectOutputStream对象中的方法writeObject
 *  5.反序列化，读取文件中的集合
 *  7.把Object类型的集合转为ArrayList类型
 */
public class Demo03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person("张三",18));
        list.add(new Person("李四",19));
        list.add(new Person("王五",20));
//        定义序列化流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("conf/list.txt"));
        oos.writeObject(list);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("conf/list.txt"));
        Object object = ois.readObject();
        ArrayList<Person> list1 =  (ArrayList<Person>) object;
        for (Person obj: list1){
            System.out.println(obj);
        }
        ois.close();
        oos.close();




    }
}
