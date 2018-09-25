package com.configuration;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

import static com.codahale.metrics.ConsoleReporter.forRegistry;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Sebastian on 2016-07-13.
 */
@Slf4j
@Configuration
@EnableMetrics
public class MetricsConfiguration {

    @Autowired
    private MetricRegistry metricRegistry;

    @Bean
    public void consoleReport() {
        log.debug("### Init Metrics Console Report");
        ConsoleReporter reporter = forRegistry(metricRegistry)
                .convertRatesTo(SECONDS)
                .convertDurationsTo(MILLISECONDS)
                .build();
        reporter.start(30, MILLISECONDS);
    }


}
