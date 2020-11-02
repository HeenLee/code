package com.li.str;

import java.util.Arrays;

import org.junit.Test;

public class Demo1_CompareStr {
	/**
	 * 以下示例通过使用str.compareTo(string)
	 */
	@Test
	public void test_compareTo(){
		String str = "Hello World";
		String str1 = "hello world";
		Object objStr = str;
		
		System.out.println(str.compareTo(str1)); //-32
		System.out.println(str.compareToIgnoreCase(str1)); //0
		System.out.println(str.codePointAt(0)); //72
		System.out.println(str1.codePointAt(0));//104
		System.out.println(str.compareTo(objStr.toString()));//0
	}
	
	/**
	 * equals()方法将此字符串与指定的对象进行比较。当且仅当参数不为null
	 * 且是表示与该对象相同的字符序列的String对象时，结果为:True
	 */
	@Test
	public void test_equals(){
		String s1 = "yiibai";
		String s2 = "yiibai";
		String s3 = new String("yiibai");
		String s4 = new String("Yiibai");
		String s5 = "中国";
		
		System.out.println(s1.equals(s2)); //true
		System.out.println(s2.equals(s3));//true
		System.out.println(s3.equals(s4));//false
		System.out.println(s3.equalsIgnoreCase(s4));//true
		System.out.println(Arrays.toString(s5.getBytes())); //[-28, -72, -83, -27, -101, -67]
	} 
	
	@Test
	public void test_denghao(){
		String s1 = "yiibai";
		String s2 = "yiibai";
		String s3 = new String("yiibai");
		String s4 = new String("Yiibai");
		System.out.println(s1==s2); //true
		System.out.println(s2==s3);//false
		System.out.println(s3==s4);//false
		
		//将字符串反转
		StringBuffer sb = new StringBuffer(s1);
		System.out.println(sb.reverse().toString());
		
		//通过转为字符数组，然后反转
		StringBuilder sb1 = new StringBuilder();
		char arr[] = s1.toCharArray();
		for (int i = arr.length - 1; i >= 0; i--) {
			sb1.append(arr[i]);
		}
		System.out.println(sb1);
		
	}
}
