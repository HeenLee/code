package com.exercise.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Demo1FieldsGet {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class personClass = Person.class;
        Field[] fields = personClass.getFields();
/*        for(Field field : fields){
            System.out.println(field);
        }*/

        Field name = personClass.getField("name");
        Person p = new Person();
        name.set(p, "AA");
        Object value = name.get(p);
        System.out.println(value.toString());

//        构造器
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        //创建对象
        Object person = constructor.newInstance("张三", 12);


//        Method method = personClass.getMethod("func",String.class,int.class);  //这边参数是字节

//        method.invoke(p,"参数");
    }
}
