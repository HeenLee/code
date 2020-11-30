package com.base.多线程;


public class MyRunnableTest {
	public static void main(String[] args) {
	
// 		创建一个线程
  		MyRunnerable mt = new MyRunnerable();
		Thread t1 = new Thread(mt);
		t1.start();
		
		System.out.println(Thread.currentThread().getName() + "     hello,mainThread");
		
//	创建10个线程
//		for (int i = 0; i < 10; i++){
//			new Thread(new MyRunnerable()).start();
//		}
	}
}
