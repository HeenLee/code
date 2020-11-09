package com.exercise.reflect;
/*
 * 获取字节码文件的三种方式
 */
public class Demo1_Reflect {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> clazz1 = Class.forName("com.li.reflect.Person");  //通过类名获取字节码文件
		Class<Person> clazz2 = Person.class;    //通过类获取字节码文件
		
		Person p = new Person();
		Class<? extends Person> clazz3 = p.getClass();  //通过实例对象获取字节码文件
		
		System.out.println(clazz1 == clazz2);
		System.out.println(clazz2 == clazz3);
		
	}

}
