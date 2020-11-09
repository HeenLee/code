package com.exercise.thread;

public class Demo6_Sleep {

	public static void main(String[] args) {
		new Thread(){
			public void run(){
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(getName() + "...aaaaaaaa");
				}
			}
		}.start();
		
		new Thread(){
			public void run(){
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(getName() + "...bb");
				}
			}
		}.start();
	}

}
