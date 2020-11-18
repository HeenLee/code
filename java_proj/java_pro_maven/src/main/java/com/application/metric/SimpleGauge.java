package com.application.metric;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class SimpleGauge {
    private static final MetricRegistry metricRegistry = new MetricRegistry();
    private static final ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry)
                                                        .convertRatesTo(TimeUnit.SECONDS)
                                                        .convertDurationsTo(TimeUnit.SECONDS).build();
    private static final BlockingDeque<Long> queue = new LinkedBlockingDeque<Long>();
    public static void main(String[] args) {

    }
}
