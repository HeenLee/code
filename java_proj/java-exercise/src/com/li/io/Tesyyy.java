package com.li.io;

public class Tesyyy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "中国";
		byte[] arr = str.getBytes();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
	}

}
