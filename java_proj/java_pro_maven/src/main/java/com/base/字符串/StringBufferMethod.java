package com.base.字符串;

import org.junit.Test;

public class StringBufferMethod {
	@Test
	public void test_method(){
		String str = "hello world";
		StringBuffer sb = new StringBuffer(str);
		sb.append("c");
		sb.append(123);
		sb.append("abc");
		
		sb.deleteCharAt(0);  //删除指定位置的字符
		System.out.println(sb.toString());
		sb.insert(0, "mm");
		String str1 = sb.reverse().toString();
		System.out.println(str1);
		
	}
}
