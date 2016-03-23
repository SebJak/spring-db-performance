package com.langpath.util.impl;

import com.google.common.io.Files;
import com.langpath.util.api.TimeLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by sjakowski on 2016-03-21.
 */
@Service("sqlTimeLogger")
public class SqlTimeLogger implements TimeLogger {

    private static final Logger logger = LoggerFactory.getLogger(SqlTimeLogger.class);

    private File LOG_FILE;

    private long start;

    private long time;

    @Autowired
    public SqlTimeLogger(@Value("${sqlTime.log}") String file_name) {
        LOG_FILE = new File(file_name);
    }

    @Override
    public void logTime(final String method, final int itemsCount) {
        try {
            end();
            StringBuilder value = prepareLog(method, itemsCount, time);
            Files.append(value, LOG_FILE, Charset.defaultCharset());
        } catch (IOException e) {
            logger.error("Error during log time. ", e);
        }

    }

    @Override
    public void start() {
        start = System.currentTimeMillis();
    }

    private void end() {
        time = System.currentTimeMillis() - start;
    }
}
