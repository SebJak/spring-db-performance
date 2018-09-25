package com.service.impl;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sebastian on 2016-03-19.
 */
public class FileReaderUtilTest {

    private static FileReaderUtil utils = new FileReaderUtil();

    @Test
    @Ignore("Can not read file from path")
    public void shouldReadOneLineFromFile() {
        final String FILE_NAME = this.getClass().getResource("words").getPath(); //"E:\\Workspa
        assertEquals(1, utils.readLines(FILE_NAME, 1).size());
    }

}