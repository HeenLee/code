package com.base.base.str;
//查找字符个数
public class Demo3_FindChar {

	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("hello how are you. ");
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'h'){
				System.out.println(i);
				count++;
			}
			
			}	
		System.out.println(count);

	}

}
