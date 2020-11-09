package com.exercise.thread;

public class Demo2_Runnable {
	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();   //4.创建Runnable的子类对象
		Thread t = new Thread(mr);			//5.将mr当作参数传递给Thread的构造函数
		t.start();							//6.开启线程
		
		for (int i = 0; i < 1000; i++) {
			System.out.println("bb");
		}
	}
}

class MyRunnable implements Runnable{  //1.定义一个类实现Runnable接口
	@Override    				// 2.重写run方法
	public void run() {   		//3.将要执行的代码写在run方法中
		for (int i = 0; i < 1000; i++) {
			System.out.println("aaaaaaaa");
		}
	}
}
