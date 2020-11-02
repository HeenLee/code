package com.li.thread;
/**
 * 同步方法
 * @author lihe
 *
 */
public class Demo92_Synchronized {

	public static void main(String[] args) {
		new Thread(){
			public void run(){
				while(true){
					Printer2.print1();
				}
			}
		}.start();
		
		new Thread(){
			public void run(){
				while(true){
					Printer2.print2();
				}
			}
		}.start();
	}

}


class Printer2{
	Demo d = new Demo();
	//非静态的同步方法的锁对象是什么？  非静态的同步方法的锁对象是this
	//静态的同步方法的锁对象是什么？ 是该类的字节码对象  Demo.class()
	public static synchronized void print1(){    //同步方法只需要在方法上加synchronized的方法
		System.out.print("黑");
		System.out.print("马");
		System.out.print("程");
		System.out.print("序");
		System.out.print("员");
		System.out.print("\r\n");
	}
	
	public static void print2(){
		synchronized(Printer2.class){
			System.out.print("传");
			System.out.print("智");
			System.out.print("播");
			System.out.print("客");
			System.out.print("\r\n");
		}
		
	}
}