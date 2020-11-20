package com.application.metric;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.MetricRegistry;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.codahale.metrics.MetricRegistry.name;

public class TestHistograms {
    //1. 实例化registry
    private static final MetricRegistry metrics = new MetricRegistry();

    //2. 实例化reporter
    private static final ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics).build();

    //3. 实例化histograms
    private static final Histogram histogram = metrics.histogram(name(TestHistograms.class, "histogram"));

    public static void main(String[] args) {
        reporter.start(3, TimeUnit.SECONDS);
        while (true){
            histogram.update(new Random().nextInt(10)*100);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
