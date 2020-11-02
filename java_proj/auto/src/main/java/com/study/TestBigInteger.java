package com.study;


import java.math.BigInteger;

public class TestBigInteger {

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		BigInteger big1 = new BigInteger("100");
		BigInteger big2 = new BigInteger("10");
		System.out.println(big1.add(big2));
		System.out.println(big1.subtract(big2));
		System.out.println(big1.multiply(big2));
		System.out.println(big1.divide(big2));
		BigInteger[] bigArr = big1.divideAndRemainder(big2);
		for (BigInteger value : bigArr) {
			System.out.println(value);
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("执行花销了" + (end - begin) + "毫秒");
		
	}

}
