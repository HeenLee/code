package com.application.metric;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import static com.codahale.metrics.MetricRegistry.name;

public class TestGauges {
    private static final MetricRegistry metrics = new MetricRegistry();
    private static Queue<String> queue = new LinkedBlockingDeque<>();

    /**
     * 在控制台输出
     */
    private static ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics).build();

    public static void main(String[] args) {
        reporter.start(1, TimeUnit.SECONDS);

        //实例化一个Guage
        Gauge<Integer> gauge = new Gauge<Integer>(){
            @Override
            public Integer getValue() {
                return queue.size();
            }
        };

        //注册到容器中
        metrics.register(name(TestGauges.class, "pending"),gauge);

        //测试jmx
//        JmxReporter jmxReporter = JmxReporter.forRegistry(metrics).build();  4.x之前提供的
        for(int i = 0; i < 20; i++){
            queue.add("a");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
