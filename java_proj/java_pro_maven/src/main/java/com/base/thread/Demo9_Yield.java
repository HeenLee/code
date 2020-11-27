package com.base.thread;
/*
 * yield让出cpu礼让线程
 */
public class Demo9_Yield {

	public static void main(String[] args) {
		new MyThread1().start();
		new MyThread1().start();
		
/*		Thread t1 = new Thread("我是1"){
			public void run(){
				for (int i = 0; i < 100; i++) {
					System.out.println(this.getName() + "...aaaaa");
				}
			}
		};
		
		Thread t2 = new Thread("我是2"){
			public void run(){
				for (int i = 0; i < 100; i++) {
					System.out.println(this.getName() + "...bb");
				}
			}
		};
		
		t1.start();
		t2.start();
		Thread.yield();*/
	}
}

class MyThread1 extends Thread{
	public void run(){
		for (int i = 0; i <= 1000; i++) {
			if(i % 10 == 0){
				Thread.yield();
			}
			System.out.println(getName() + "..." + i);
		}
	}
}