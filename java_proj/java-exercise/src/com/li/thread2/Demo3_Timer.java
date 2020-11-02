package com.li.thread2;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Demo3_Timer {

	public static void main(String[] args) {
		Timer t = new Timer();
		//在指定时间安排指定任务
		//第一个参数,是安排的任务,第二个参数是执行的时间,第三个参数是过多长时间再重复执行
		t.schedule(new MyTimerTask(), new Date(), 3000L);
		
		while(true){
			try {
				Thread.sleep(1000);
				System.out.println(new Date());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class MyTimerTask extends TimerTask{
	public void run(){
		System.out.println("背单词了");
	}
}