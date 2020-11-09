package com.exercise.thread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo8_ThreadPool {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);  //创建线程池
		pool.submit(new MyRunnable());							//将线程放进池子里并执行
		pool.submit(new MyRunnable());
		pool.shutdown(); 			//关闭线程池
	}

}
