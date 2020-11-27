package com.base.thread3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Lock

 */
public class Demo04Lock implements Runnable{
    private int ticket = 100;

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
                lock.lock();
                if(ticket > 0 ){
                    try {
                        Thread.sleep(10);
                        System.out.println(Thread.currentThread().getName() + "正在-->售卖第" + ticket + "票");
                        ticket--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();  //
                    }

                }

            }
        }
    }
