package com.base.多线程;

public class ThreadExcuteTest {
	public static void main(String[] args) {
		System.out.println("main start...."); //主线程
		Thread t = new Thread(){
			public void run(){
				System.out.println("多线程 run...");  //子线程
					try {
						Thread.sleep(10);         //子线程等待
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("多线程 end");
			}
		};
		t.start();
		try {
			Thread.sleep(20);   //主线程等待
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main end");  //主线程
	}
}
