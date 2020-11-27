package com.base.thread;
/**
 * 需求:铁路售票,一共100张,通过四个窗口卖完.
 */
public class Demo93_Ticket {

	public static void main(String[] args) {
		new Ticket().start();
		new Ticket().start();
		new Ticket().start();
		new Ticket().start();
	}

}

class Ticket extends Thread{
	private  static int ticket = 100;
//	private  static Object obj = new Object(); //如果用引用数据类型成员变量当做锁对象，必须是静态的.因为静态变量是共享的独一份。
	public void run(){
		while(true){
			synchronized(Ticket.class){
				if(ticket <= 0){
					break;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(getName() + "...这是第" + ticket-- + "号票" );
			}
		}
	}
}