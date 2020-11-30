package com.base.反射.构造器反射;

import com.base.反射.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
 Class类的newInstance()方法是使用该类无参的构造函数创建对象, 如果一个类没有无参的构造函数,
就不能这样创建了,可以调用Class类的getConstructor
(String.class,int.class)方法获取一个指定的构造函数然后再调用Constructor类的newInstance
("张三",20)方法创建对象
 */
public class Demo03_Constructor {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = Class.forName("com.base.反射.Person");
//		Person p = (Person) clazz.newInstance();  //通过无参构造创建对象
//		System.out.println(p);
		Constructor<?> c = clazz.getConstructor(String.class,int.class,String.class); //获取有参构造
		 Person p1 = (Person) c.newInstance("张三",18,"女");								//通过有参构造创建对象
		 System.out.println(p1);
		 
/*		 Constructor<?>[] c1 =  clazz.getConstructors();
		 for (int i = 0; i < c1.length; i++) {
			System.out.println(c1[i].n);
		}*/
		 
		
		
	}

}
