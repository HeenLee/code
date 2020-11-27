package com.base.thread;
/**
 * 某一个线程执行时，其他线程必须等待：
 * @author lihe
 *
 */
public class SynchronizedTest {

	public static void main(String[] args) throws InterruptedException {
		AddThread add = new AddThread();
		DecThread dec = new DecThread();
		
		add.start();
		dec.start();
		
		add.join();
		dec.join();
		
		System.out.println(Counter.count);
	}
}


class Counter{
	public static final Object lock = new Object();
	public static int count = 0;
}
class AddThread extends Thread{
	public void run(){
		for (int i = 0; i < 10000; i++){
//			加锁
			synchronized (Counter.lock) {
				Counter.count += 1;
			}
			
		}
	}
}

class DecThread extends Thread{
	public void run(){
		for (int i = 0; i < 10000; i++){
			synchronized (Counter.lock) {
				Counter.count -= 1;

			}
			
		}
	}
}
