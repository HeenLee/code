package com.base.reflect;
/*
 * 
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/*
Class.getMethod(String, Class...) 和 Class.getDeclaredMethod(String,
Class...)方法可以获取类中的指定方法,调用invoke(Object,
Object...)可以调用该方法,Class.getMethod("eat") invoke(obj)
Class.getMethod("eat",int.class) invoke(obj,10)
 */
public class Demo04_Method {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> clazz = Class.forName("com.base.reflect.Person");   //创建字节码文件
		Constructor<?> c = clazz.getConstructor(String.class,int.class); //获取有参构造
		Person p = (Person) c.newInstance("张武",14);						//通过有参构造创建对象
		Method m = clazz.getMethod("getAge");   //获取无参的方法
		m.invoke(p);//调用无参方法，不传参
		System.out.println(p.getAge());


		Method m2 = clazz.getMethod("setAge", int.class);  //获取有参的方法
		m2.invoke(p, 10);								//调用有参的方法，传参
		System.out.println(p.getAge());
		
	}

}
