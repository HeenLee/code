package com.exercise.thread3;

/**
 * 包子铺
 * 注意：包子铺线程和包子线程关系--通信
 * 必须同步技术包子两个线程只能有一个在执行
 *
 */
public class Baozipu extends Thread{
    //需要在成员位置创建一个包子变量
    private Baozi bz;

    //使用带参数构造方法，为这个包子变量赋值
    public Baozipu(Baozi bz){
        this.bz = bz;

    }
    //设置线程任务：生成包子
    @Override
    public void run() {
        int count = 0;
        while (true){
            synchronized (bz){
                //对包子的状态进行判断
                if(bz.flag == true){
                    //包子铺调用wait方法进入等待状态
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //被唤醒之后执行，包子铺生成包子
                //增加一些趣味性:交替生成两种包子
                if(count % 2 == 0){
                    //生成薄皮包子
                    bz.pi = "薄皮";
                    bz.xian = "三鲜馅";
                }else{
                    //生成 冰皮 牛肉大葱馅
                    bz.pi = "冰皮";
                    bz.xian = "牛肉大葱馅";
                }
                count++;
                System.out.println("包子铺正在生成：" + bz.pi + bz.xian );
                //生成包子需要3s
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //修改包子状态为有
                bz.flag = true;
                bz.notify();
                System.out.println("包子铺已经生成好包子");

            }
        }
        //必须同时同步技术保证两个线程只能有一个在执行

    }


}
