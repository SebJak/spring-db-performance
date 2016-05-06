package com.common.service.api;

import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by sjakowski on 2016-03-21.
 */
public class TimeLogger {

    private static final Logger logger = LoggerFactory.getLogger(TimeLogger.class);

    private File LOG_FILE;

    private long start;

    private long time;

    public StringBuilder prepareLog(final String method, final int count, final long time) {
        StringBuilder value = new StringBuilder();
        value.append(method);
        value.append(", ");
        value.append(count);
        value.append(", ");
        value.append(time);
        value.append("\n");
        return value;
    }

    @Autowired
    public TimeLogger(String file_name) {
        LOG_FILE = new File(file_name);
    }

    public void logTime(final String method, final int itemsCount) {
        try {
            end();
            StringBuilder value = prepareLog(method, itemsCount, time);
            Files.append(value, LOG_FILE, Charset.defaultCharset());
        } catch (IOException e) {
            logger.error("Error during log time. ", e);
        }

    }

    public void start() {
        start = System.currentTimeMillis();
    }

    private void end() {
        time = System.currentTimeMillis() - start;
    }

}
