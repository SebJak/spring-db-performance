package com.langpath.test.util;

import com.langpath.util.FileReaderUtil;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sebastian on 2016-03-19.
 */
public class FileReaderUtilTest {

    private static FileReaderUtil utils;
    private static final String FILE_NAME = "E:\\Workspace\\workspace_JaVa\\_mgr\\spring-data-performance\\src\\test\\resources\\com.langpath.service.impl\\words.txt";

    @Test(expected = NullPointerException.class)
    public void testAssertion() {
        utils.readLines(1);
    }

    @org.junit.Test
    public void testReadLines() throws Exception {
        utils = new FileReaderUtil(FILE_NAME);
        assertEquals("Size of list should be equal 1", 1, utils.readLines(1).size());
    }

}