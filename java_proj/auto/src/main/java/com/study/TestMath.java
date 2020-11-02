package com.study;

public class TestMath {
/**
 * 随机数 [0.0,1.0)
 */
	public static void main(String[] args) {
		double value = Math.random();
		System.out.println(value);
		
		//生成[a,b)之间的数     Math.random()*(b-a) + a   生成[1,3)
		//生成[a,b]之间的数     (int)(Math.random()*(b-a) + a + 1)
		double num = Math.random()*2 + 1;
		System.out.println(num);
		
		int num1 = (int)(Math.random()*2 + 1 + 1);
		System.out.println(num1);
		
	}

}
