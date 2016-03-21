package com.langpath.util.impl;

import com.google.common.io.Files;
import com.langpath.util.TimeLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by sjakowski on 2016-03-21.
 */
public class SqlTimeLogger implements TimeLogger {

    private static final Logger logger = LoggerFactory.getLogger(SqlTimeLogger.class);

    private static final String FILE_NAME = "./sqlTimeExecution";

    private static final File LOG_FILE = new File(FILE_NAME);

    static {
        if(!LOG_FILE.exists()) {
            LOG_FILE.mkdirs();
        }
    }

    @Override
    public void logTime(final String method, final int itemsCount, final long time) {
        try {
            StringBuilder value = prepareLog(method, itemsCount, time);
            Files.append(value, LOG_FILE, Charset.defaultCharset());
        } catch (IOException e) {
            logger.error("Error during log time. ", e);
        }

    }
}
