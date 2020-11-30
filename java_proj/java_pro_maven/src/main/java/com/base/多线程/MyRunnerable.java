package com.base.多线程;
/**
 * 实现接口创建线程
 * @author lihe
 *
 */
public class MyRunnerable implements Runnable{

	@Override
	public void run() {
		int i = 0;
		while(i<10){
			System.out.println(Thread.currentThread().getName());
			System.out.println(i);
			i++;
		}
	}

}
