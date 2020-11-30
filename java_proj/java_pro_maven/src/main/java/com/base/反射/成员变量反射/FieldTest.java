package com.base.反射.成员变量反射;

import com.base.反射.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
/*
 Class.getField(String)方法可以获取类中的指定字段(可见的),
  如果是私有的可以用getDeclaredField("name")方法获取,通过set(obj, "李四")方法可以设置指定对象上该字段的值,
 如果是私有的需要先调用setAccessible(true)设置访问权限,用获取的指定的字段调用get(obj)可以获取指定对象中该字段的值
 @throws Exception 
 */

public class FieldTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class<?> clazz = Class.forName("com.base.反射.Person");
		Constructor<?> c = clazz.getConstructor(String.class,int.class);  //获取有参构造
		Person p = (Person) c.newInstance("张三",18);  //该属性都是私有的    //通过有参构造创建对象
//		Field f = clazz.getField("heigh");   //获取身高字段  heigh是public的
//		f.set(p, "160");					//修改身高字段值
		
		Field f = clazz.getDeclaredField("name"); //暴力反射获取字段
		f.setAccessible(true);					 //去除私有权限
		f.set(p, "李四");
		System.out.println(p);    
		
		
	}

}
