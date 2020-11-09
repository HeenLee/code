package com.exercise.thread;

public class ThreadExcuteTest1 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable(){

			public void run() {
				for(int i = 0; i < 100; i++){
					System.out.println(Thread.currentThread().getName() + "  " + i);
				}
			}
			
		});
		t.start();
		//主线程挂起，子线程执行完后开始执行主线程
		t.join();
		
		for(int i = 0; i < 100; i++){
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

}
