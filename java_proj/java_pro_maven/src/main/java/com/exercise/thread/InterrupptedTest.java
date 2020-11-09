package com.exercise.thread;

public class InterrupptedTest {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + "  " + i);
				}
			}
		});
		
//		Thread t2 = new Thread(new Runnable(){
//			@Override
//			public void run() {
//				for (int i = 0; i < 100; i++) {
//					System.out.println(Thread.currentThread().getName() + "  " + i);
//				}
//			}
//		});
		t1.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
//		t2.start();
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "  " + i);
		}
		
		
	}

}
