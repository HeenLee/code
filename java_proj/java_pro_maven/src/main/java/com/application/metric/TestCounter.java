package com.application.metric;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import static com.codahale.metrics.MetricRegistry.name;

public class TestCounter {
    //1. 实例化一个registry
    private static final MetricRegistry metrics = new MetricRegistry();

    /**
     * 2. 在控制台输出
     */
    private static ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics).build();

    //3. 注册到容器中
    private static Counter counter = metrics.counter(name(TestCounter.class,"counter"));

    private static Queue<String> queue = new LinkedList<>();

    public static void add(String str){
        counter.inc();
        queue.offer(str);
    }

    public static String take(){
        counter.dec();
        return queue.poll();
    }

    public static void main(String[] args) {
        reporter.start(1, TimeUnit.SECONDS);
        while (true){
            add("1");
//            take();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
