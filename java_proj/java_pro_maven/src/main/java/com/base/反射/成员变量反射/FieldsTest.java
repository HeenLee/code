package com.base.反射.成员变量反射;
/**
 * 反射获取成员变量。getFields()只能获取public修饰的成员变量
 * getDeclaredField()可以获取私有变量
 */

import com.base.反射.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class FieldsTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class personClass = Person.class;  //获取字节码
        Field[] fields = personClass.getFields(); //获取public修饰的成员变量
        for(Field field : fields){         //遍历获取的属性列表  public java.lang.String com.base.反射.Person.name
            System.out.println(field);
        }
        System.out.println("--------------------------------");
        Field[] fieldAll = personClass.getDeclaredFields();  //获取全部的成员变量，包括private修饰的
        for (Field field : fieldAll) {
            System.out.println(field);
        }

        System.out.println("---------------------------");

        //根据指定的属性名称获取public修饰的成员变量
        Field name = personClass.getField("name");
        System.out.println(name);  //public java.lang.String com.base.反射.Person.name

        System.out.println("--------------------------------");

        //根绝指定的名称获取private修饰的变量
        Field age = personClass.getDeclaredField("age");
        System.out.println(age);


        //获取了成员变量后需要赋值  set(Object obj , String name)  get()
        Person person = new Person();
        name.set(person,"lili");   //给属性name赋值
        age.setAccessible(true);   //获取private属性
        age.set(person,12);
        System.out.println(name.get(person)); // 获取属性值
        System.out.println(name.getName()); //获取属性名称
        System.out.println(age.get(person));  //获取属性值


//        Person p = new Person();
//        name.set(p, "AA");
//        Object value = name.get(p);
//        System.out.println(value.toString());

//        构造器
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        //创建对象
//        Object person = constructor.newInstance("张三", 12);


//        Method method = personClass.getMethod("func",String.class,int.class);  //这边参数是字节

//        method.invoke(p,"参数");
    }
}
