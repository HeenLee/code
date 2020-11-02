package com.li.thread;
/**
 * 有三个线程
 * Thread.currentThread()获取当前线程
 * @author lihe
 *
 */
public class Demo5_CurrentThread {

	public static void main(String[] args) {
		new Thread(){
			public void run(){
				System.out.println(getName() + "...aaaaaaaa");
			}
		}.start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "...bbb");
			}
		}).start();
		
		Thread.currentThread().setName("我是主线程");
		System.out.println(Thread.currentThread().getName());
	}
}
