package com.li.reflect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/*
 * 
 */
public class Demo2_Reflect {

	public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
		Juicer j = new Juicer();
		BufferedReader br = new BufferedReader(new FileReader("conf.prop"));
		Class<?> clazz = Class.forName(br.readLine());  //获取字节码文件
		
		Fruit f = (Fruit) clazz.newInstance();    //通过class创建类的对象
		j.run(f);
		br.close();
	}

}

interface Fruit{
	public void squeeze();
}

class Apple implements Fruit{
	@Override
	public void squeeze() {
		System.out.println("榨出一杯苹果汁");
	}
}

class Orange implements Fruit{
	@Override
	public void squeeze() {
		System.out.println("榨出一杯橘子汁");
	}
}

class Juicer{
	public void run(Fruit f){
		f.squeeze();
	}
}