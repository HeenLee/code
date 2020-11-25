package com.exercise.thread3;

/**
 * 模拟卖票案例
 * 创建3个线程，同时开始，对共享的票进行出售
 */
public class Demo04Ticket {
    public static void main(String[] args) {
        Demo04Lock r = new Demo04Lock();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();

    }
}
