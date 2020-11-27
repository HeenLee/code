package com.base.thread;
/*
 * 守护线程.  当用户线程执行完时，守护线程就会自动停止
 */
public class Demo7_Daemon {

	public static void main(String[] args) {
		Thread t1 = new Thread(){
			public void run(){
				for (int i = 0; i < 2; i++) {
					System.out.println(getName() + "...aaaaaaa");
				}
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				for (int i = 0; i < 1000; i++) {
					System.out.println(getName() + "...bb");
				}
			}
		};
		
		t2.setDaemon(true);
		
		t1.start();
		t2.start();
	}

}
