package com.li.collection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Demo7_Properties {

	public static void main(String[] args) throws IOException {
		Properties p = new Properties();
		try {
			//加载配置文件
			p.load(new FileReader("conf.properties"));
			
			System.out.println(p.getProperty("name"));
			System.out.println(p.getProperty("age"));
			System.out.println(p.getProperty("school"));
			//添加属性
			p.setProperty("gender", "m");
			//将新的属性写入
			p.store(new FileWriter("conf.properties"), "111");
			System.out.println(p.getProperty("gender"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//封装一个方法读取
		System.out.println(readValue("D:\\workspace\\java-exercise\\conf.properties","name"));
	}

	private static String readValue(String fileName, String key) throws IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(fileName));
		String value = prop.getProperty(key);
		System.out.println(key + ":" + value);
		return value;
	}
}
