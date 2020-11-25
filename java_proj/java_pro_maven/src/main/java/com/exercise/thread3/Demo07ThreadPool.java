package com.exercise.thread3;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池  jdk1.5之后提供
 * java.util.concurrent.Executors  线程池的工厂类，用来生产线程池
 * Executors类中有生产固定线程数的线程池
 *  static ExecutorService newFixedThreadPool(int nThreads)
 *   返回ExecutorService接口
 *   从线程池中获取线程，调用start()执行线程任务
 *      submit(Runnable task) 提交一个任务用于执行
 *   关闭/销毁线程池的方法
 *   void shutdown()
 */
public class Demo07ThreadPool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(4);
        es.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "A");
            }
        });

        es.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "B");
            }
        });

        es.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "C");
            }
        });
    }

}
