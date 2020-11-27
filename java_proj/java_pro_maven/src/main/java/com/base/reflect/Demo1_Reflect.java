package com.base.reflect;
/*
 * 获取字节码文件的三种方式
 */
public class Demo1_Reflect {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		Class<?> clazz1 = Class.forName("com.base.reflect.Person");  //1. 通过类名获取字节码文件
		Class<Person> clazz2 = Person.class;    //2. 通过类的class属性获取字节码文件
		
		Person p = new Person();
		Class<? extends Person> clazz3 = p.getClass();  //3. 通过实例对象获取字节码文件
		
		System.out.println(clazz1 == clazz2);
		System.out.println(clazz2 == clazz3);

		Person o = (Person)clazz1.newInstance();
	}

}
