package com.exercise.thread3;

public class Demo02Ticket {
    public static void main(String[] args) {
        Demo02SynchronizedRunnableImpl d = new Demo02SynchronizedRunnableImpl();
        Thread t1 = new Thread(d);
        Thread t2 = new Thread(d);
        Thread t3 = new Thread(d);

        t1.start();
        t2.start();
        t3.start();
    }
}
