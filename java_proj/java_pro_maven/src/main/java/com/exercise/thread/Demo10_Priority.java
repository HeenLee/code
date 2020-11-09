package com.exercise.thread;
/**
 * 优先级 1-10   10最高     默认为5
 * @author lihe
 *
 */
public class Demo10_Priority {

	public static void main(String[] args) {
		Thread t1 = new Thread(){
			public void run(){
				for (int i = 0; i < 100; i++) {
					System.out.println(getName() + "...aaaaaa");
				}
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				for (int i = 0; i < 100; i++) {
					System.out.println(getName() + "...bb");
				}
			}
		};
		//可以为数字
//		t1.setPriority(10);
//		t2.setPriority(1);
		//也可以为变量
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
	}

}
