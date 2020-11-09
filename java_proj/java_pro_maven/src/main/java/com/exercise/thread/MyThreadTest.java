package com.exercise.thread;

public class MyThreadTest {

	public static void main(String[] args) {
//		一个线程
//		MyThread t = new MyThread();
//		t.start();
		
//		多个线程
		for (int i = 0; i < 10; i++){
			new MyThread().start();
		}
		System.out.println(Thread.currentThread().getName() + "  hello");
	}

}
