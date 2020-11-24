package com.exercise.thread3;

/**
 * 模拟卖票案例
 * 创建3个线程，同时开始，对共享的票进行出售
 */
public class Demo01Ticket {
    public static void main(String[] args) {
        Demo01RunnableImpl r = new Demo01RunnableImpl();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();

    }
}
