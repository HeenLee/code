package com.base.字符串;

import org.junit.Test;

public class StringMethod {
	@Test
	public void test_method(){
		String str = "hello world";
		String str1 = "hello world";
		String str2 = "";
		String str3 = " ";
		String str4 = null;
		System.out.println(str.charAt(0));  //char chatAt()
		System.out.println(str.codePointCount(0,2)); //int codePointAt
		System.out.println(str.compareTo(str1));
		System.out.println(str.contentEquals("e"));
		System.out.println(str.equals(str1));
		System.out.println(String.format("hello, %s", str));
		byte[] arr = str.getBytes();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		System.out.println(str.indexOf('e'));   //查找字符或者字符串
		System.out.println(str.indexOf("ll"));
		System.out.println(str.indexOf("o", 8));  //从fromIndex开始查找
		System.out.println(str.indexOf("he", 2));
		
		System.out.println(str.length());
		System.out.println(str2.isEmpty()); //true  当字符串为空时，length为0，返回true    
		System.out.println(str3.isEmpty()); //false  
		System.out.println(str4 == null);
		
		String newStr = String.join(",", "a","b","c","d");//用分隔符","将字符串连接起来
		System.out.println(newStr);
		
		System.out.println(str.matches("[\\s]*"));
		System.out.println(str.startsWith("he"));
		System.out.println(str.startsWith("h", 1));
		
		char[] c = str.toCharArray();
		for (char d : c) {
			System.out.print(d + " ");
		}
		System.out.println("\r\n"+str.toUpperCase());
		
		System.out.println(String.valueOf("123"));
		System.out.println(String.valueOf(false));
		System.out.println(String.valueOf(new char[]{'a','b'}));
		
		System.out.println(str.substring(1));
		System.out.println(str.substring(4,6));
		
		
		
	}

}
