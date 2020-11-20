package com.application.metric;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.TimeUnit;

import static com.codahale.metrics.MetricRegistry.name;

public class TestMeters {
    //实例化registry
    private static final MetricRegistry metrics = new MetricRegistry();

    //报告对象
    private static final ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics).build();

    //实例化meter
    private static final Meter meter = metrics.meter(name(TestMeters.class, "request"));

    public static void main(String[] args) {
        reporter.start(1, TimeUnit.SECONDS);

        while (true){
            meter.mark();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
