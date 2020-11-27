package com.base.thread3;

public class Demo01RunnableImpl implements Runnable{
    //定义一个多线程共享的票源
    private int ticket = 100;

    //设置线程任务，卖票
    @Override
    public void run() {
        //使用死循环，让卖票操作重复执行
        while (true){
            if(ticket > 0){  //先判断票是否存在
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //票存在，卖票 ticket--
                System.out.println(Thread.currentThread().getName() + "--->正在卖第" + ticket + "张票" );
                ticket--;
            }
        }
    }
}
