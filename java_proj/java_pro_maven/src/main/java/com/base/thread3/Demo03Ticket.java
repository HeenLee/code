package com.base.thread3;

public class Demo03Ticket {
    public static void main(String[] args) {
        Demo03SynchronizedMethod d = new Demo03SynchronizedMethod();
        Thread t1 = new Thread(d);
        Thread t2 = new Thread(d);
        Thread t3 = new Thread(d);

        t1.start();
        t2.start();
        t3.start();
    }
}
