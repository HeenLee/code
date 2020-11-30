package com.base.多线程;
/*
 守护线程
  守护线程是为其他线程服务的线程；
  所有非守护线程都执行完毕后，虚拟机退出；
  守护线程不能持有需要关闭的资源（如打开文件等）。
 */
public class DaemonThreadTest {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable(){
			@Override
			public void run() {
				for (int i = 0; i < 20000; i++) {
					System.out.println(Thread.currentThread().getName() + "  " + i);
				}
			}
		});
		t.setDaemon(true);
		t.start();
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + "  " + i);
		}
	}

}
