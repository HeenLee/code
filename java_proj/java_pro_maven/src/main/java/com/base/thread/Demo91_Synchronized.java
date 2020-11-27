package com.base.thread;

/*
 * 同步代码块
 */
public class Demo91_Synchronized {
	static Printer p = new Printer();
	public static void main(String[] args) {
		new Thread(){
			public void run(){
				while(true){
					p.print1();
				}
			}
		}.start();
		
		new Thread(){
			public void run(){
				while(true){
					p.print2();
				}
			}
		}.start();
	}

}


class Printer{
	Demo d = new Demo();
	public void print1(){
//		synchronized(new Demo()){
		synchronized(d){                            //同步代码块，锁机制，锁对象可以是任意的
			System.out.print("黑");
			System.out.print("马");
			System.out.print("程");
			System.out.print("序");
			System.out.print("员");
			System.out.print("\r\n");
		}
	}
	
	public void print2(){
//		synchronized(new Demo()){			//锁对象不能用匿名对象，因为匿名对象不是同一个对象
		synchronized(d){
			System.out.print("传");
			System.out.print("智");
			System.out.print("播");
			System.out.print("客");
			System.out.print("\r\n");
		}
	}
}

class Demo{
	
}