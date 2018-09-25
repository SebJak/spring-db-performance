package com.langpath.configuration;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.CsvReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.graphite.Graphite;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sebastian on 2016-07-13.
 */
//@Configuration
//@EnableMetrics
public class MetricsConfigurationSql {

    private static Logger logger = LoggerFactory.getLogger(MetricsConfigurationSql.class);

    @Autowired
    private MetricRegistry metricRegistry;

    //@PostConstruct
    public void csvReport() {
        File timeDir = new File("../timeExecution");
        timeDir.mkdir();
        logger.info("Time directory created at: " + timeDir.getAbsolutePath());
        logger.debug("Init csvReport");
        CsvReporter reporter = CsvReporter.forRegistry(metricRegistry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build(timeDir);
        reporter.start(5, TimeUnit.SECONDS);
    }



}
