package com.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnimalTest {
    public static void main(String[] args) {
        Class<Animal> clazz = Animal.class;
        try {
            Animal animal = clazz.newInstance();  //创建一个Animal对象，调用无参构造

            Method method = clazz.getMethod("eat");  //反射获取成员方法
            method.invoke(animal);//成员方法调用

            Field name = clazz.getDeclaredField("name");  //需要暴力反射获取
            name.setAccessible(true);   //去掉private权限
            name.set(animal,"孙悟空");    //name属性赋值
            System.out.println(name.get(animal));  //获取name属性值
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------");
        //创建一个有参构造对象
        Constructor<Animal> animalParam = null;
        try {
            animalParam = clazz.getConstructor(String.class, int.class);
            Animal animal = animalParam.newInstance("美猴王", 13);
            animal.eat();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }




    }
}
