package com.li.thread;
/*
 * 线程设置名称两种方式：
 * 1.构造方法
 * 2.setName()
 */
public class Demo4_Name {
	public static void main(String[] args) {
		demo1();
		final Thread t1 = new Thread(){
			public void run(){
//				this.setName("张三");
				System.out.println(this.getName() + "...aaaaaaaa");
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
//				this.setName("李四");
				System.out.println(this.getName() + "...bb");
			}
		};
		
		t1.setName("张三");
		t2.setName("李四");
		t1.start();
		t2.start();
		
	}

	private static void demo1() {
		new Thread("芙蓉"){        //通过构造方法给name赋值
			public void run(){
				System.out.println(this.getName() + "...aaaaaaaaa");
			}
		}.start();
		
		new Thread("乖乖"){        //通过构造方法给name赋值
			public void run(){
				System.out.println(this.getName() + "...bb");
			}
		}.start();
	}
}
