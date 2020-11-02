package com.study;
/**
 * 一、构造方法
public Character(char value)      构造一个新分配的Character对象，代表指定的char值。
二、常用方法
1、public static boolean isDigit()/isLetter   判断是否是数字字符/字母
2、public static boolean isUpperCase()/isLowerCase() 判断是否是大写/小写
3、public static boolean isWhiteSpace 判断是否为空格
4、public static char toUpperCase()/toLowerCase()  转大写/小写
 */
public class TestCharacter {
	public static void main(String[] args) {
		Character c = new Character('c');
		System.out.println(Character.isDigit(c));
		System.out.println(Character.isLetter(c));
		System.out.println(Character.isWhitespace(c));
		Character c1 = new Character('\t'); 
		System.out.println(Character.isWhitespace(c1));
	}
}
