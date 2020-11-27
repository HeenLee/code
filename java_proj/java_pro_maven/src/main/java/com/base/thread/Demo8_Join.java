package com.base.thread;
/**
 * 插队线程：当前线程暂停, 等待指定的线程执行结束后, 当前线程再继续
 * 
 * @author lihe
 *
 */
public class Demo8_Join {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(){
			public void run(){
				for (int i = 0; i < 1000; i++) {
					System.out.println(getName() + "...aaaaaaaaa");
				}
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				for (int i = 0; i < 1000; i++) {
/*					if(i == 2){
						try {
							//t1.join();
							t1.join(1); //插队指定的时间,过了指定时间后,两条线程交替执行
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}*/
					System.out.println(getName() + "...bb");
				}
			}
		};
		
		t1.start();
		t2.start();
		t2.join();
		//主线程
/*		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName() + "...ccc");
		}*/
		
		
		
		
		
	}

}
