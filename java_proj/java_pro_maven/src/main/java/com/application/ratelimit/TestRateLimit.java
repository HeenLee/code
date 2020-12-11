package com.application.ratelimit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 令牌桶类，限制每秒请求数
 */
public class TestRateLimit {
    public static void main(String[] args) {
        //testNoRateLimit();
        //testWithRateLimite();
        test_rate();


    }

    /**
     * 没有使用限制的情况.计算执行的时间差
     */
    public static void testNoRateLimit(){

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println();
        long endTime = System.currentTimeMillis();

        System.out.println("花费时间:" + (endTime - startTime));
    }


    public static void testWithRateLimite(){
        long startTime = System.currentTimeMillis();
        //设置每秒不超过10个任务
        RateLimiter rateLimit = RateLimiter.create(10.0);   //每秒最大处理10个任务

        for (int i = 0; i < 20; i++) {   //总共20个任务
            //限制请求，最大不超过10个任务，超过最大就会阻塞
            rateLimit.acquire();
            System.out.print(i);
        }
        System.out.println();
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }

    public  static void test_rate(){
        RateLimiter rateLimiter = RateLimiter.create(10.0);
        while(true){
            rateLimiter.acquire();
            System.out.println(1);
        }
    }
}
