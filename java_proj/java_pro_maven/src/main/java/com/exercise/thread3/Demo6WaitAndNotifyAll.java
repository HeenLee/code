package com.exercise.thread3;
/*
wait(long time)
唤醒的方法：
    notify() 唤醒单个线程。如果有多个等待线程，随机唤醒一个
    notifyAll()  唤醒对象监视器的所有线程。
 */
public class Demo6WaitAndNotifyAll {
    public static void main(String[] args) {
        //创建锁对象，保证唯一
        Object obj = new Object();
        //创建一个顾客线程(消费者)
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {  //一直等着买包子
                    //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                    synchronized (obj) {
                        System.out.println("顾客1告知老板要的包子种类和数量");
                        try {
                            obj.wait();   //带参数
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        //唤醒之后执行的代码
                        System.out.println("包子做好了，顾客1开吃");

                        System.out.println("=======================");
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {  //一直等着买包子
                    //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                    synchronized (obj) {
                        System.out.println("顾客2告知老板要的包子种类和数量");
                        try {
                            obj.wait();   //带参数
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        //唤醒之后执行的代码
                        System.out.println("包子做好了，顾客2开吃");

                        System.out.println("=======================");
                    }
                }
            }
        }).start();



        //创建一个老板线程(生产者)
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj){
                        System.out.println("老板5s后做好包子，告知顾客吃");
                        obj.notifyAll();

                    }
                }
            }
        }).start();
    }
}
