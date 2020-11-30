package com.base.多线程;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public class My {
	@Test
	public void testH() throws InterruptedException{
		
		CountDownLatch latch=new CountDownLatch(100);
		for(int i = 0; i< 20 ;i++){
			new Thread(new MyRunnerable()).start();
			Thread.sleep(1000);
//			t1.setName("线程"+ i);
//			System.out.println("ssssssss");
//			Thread t2 = new Thread(new MyThread());
//			t2.setName("线程"+ i);

//			t1.start();
//			t2.start();
			Thread.sleep(1000);
//			latch.await();
			
		}
//		System.out.println(Thread.currentThread().getName() + "heh ");
	}

}
