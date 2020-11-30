package com.base.字符串;

//删除字符串中的某个字符
public class Demo2_RemoveStr {

	public static void main(String[] args) {
		String s = "helloworld";
		String newStr = removeAtChar(s, 2);
		System.out.println(newStr);
		
		
		String s1 = " ";
		System.out.println(removeAtChar(s1, 2));

	}
	
	public static String removeAtChar(String str, int index){
		if(str.length() == 0 || str == null){
			System.out.println("请输入正常的：");
		}
		if(str.length() < index){
			new Exception("太长");
		}
		
		String s = str.substring(0, index) + str.substring(index + 1);
		return s;
	}

}
