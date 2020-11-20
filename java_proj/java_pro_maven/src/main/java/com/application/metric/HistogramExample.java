package com.application.metric;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static com.codahale.metrics.MetricRegistry.name;

public class HistogramExample {
    private static final MetricRegistry registry = new MetricRegistry();
    private static final ConsoleReporter reporter = ConsoleReporter.forRegistry(registry)
                                                        .convertRatesTo(TimeUnit.SECONDS)
                                                        .convertDurationsTo(TimeUnit.SECONDS).build();
    private static final Histogram histogram = registry.histogram(name(HistogramExample.class,"result"));
    public static void main(String[] args) {
        reporter.start(1, TimeUnit.SECONDS);
        while (true){
            histogram.update(1);
        }

    }

}
