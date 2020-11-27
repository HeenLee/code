package com.base.thread3;

/**
 *
 */
public class Chihuo extends Thread{
    //需要在成员位置创建一个包子变量
    private Baozi bz;

    //使用带参数构造方法，为这个包子变量赋值
    public Chihuo(Baozi bz) {
        this.bz = bz;
    }
    @Override
    public void run() {

        while (true){
            synchronized (bz){
                if(bz.flag == false){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //被唤醒之后执行的代码，吃包子
                System.out.println("吃货正在吃" + bz.pi + bz.xian);

                bz.flag = false;
                bz.notify();
            }
        }

    }
}
