package com.base.thread3;
/*
卖票案例出现了线程安全问题  卖出了不存在的票和重复的票

同步代码块
     synchronized(锁对象){
        可能出现线程安全问题的代码(访问了共享数据的代码)
     }

 */
public class Demo02SynchronizedBlockImpl implements Runnable{
    private int ticket = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true){
            //同步代码块
            synchronized(obj){
                if(ticket > 0 ){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在-->售卖第" + ticket + "票");
                    ticket--;
                }
            }
        }
    }
}
