package com.exercise.thread;

public class Demo1_Thread  {
	public static void main(String[] args) {
		MyThread mt = new MyThread();  //4.创建Thread类的子类对象
		mt.start();					//5.开启线程
		
		for (int i = 0; i < 1000; i++) {  //主线程
			System.out.println("bb");
		}
	}
}



class MyThread extends Thread{  //1.继承Thread
	@Override    				// 2.重写run方法
	public void run() {   		//3.将要执行的代码写在run方法中
		for (int i = 0; i < 1000; i++) {
			System.out.println("aaaaaaaa");
		}
	}
}
