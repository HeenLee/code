package com.base.thread3;

public class Demo02Ticket {
    public static void main(String[] args) {
        Demo02SynchronizedBlockImpl d = new Demo02SynchronizedBlockImpl();
        Thread t1 = new Thread(d);
        Thread t2 = new Thread(d);
        Thread t3 = new Thread(d);

        t1.start();
        t2.start();
        t3.start();
    }
}
