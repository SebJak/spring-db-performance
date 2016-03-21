package com.langpath.service.impl;

import com.langpath.test.util.FileReaderUtil;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

/**
 * Created by Sebastian on 2016-03-18.
 */
public class WordServiceTest {

    private static FileReaderUtil utils;
    private static final String FILE_NAME = "E:\\Workspace\\workspace_JaVa\\_mgr\\spring-sql-performance\\src\\test\\resources\\com.langpath.service.impl\\words.txt";

    @BeforeClass
    public static void init() {
        utils = new FileReaderUtil(FILE_NAME);
    }

    @org.junit.Test
    public void testReadLines() throws Exception {
        assertEquals("Size of list should be equal 1", 1, utils.readLines(1).size());
    }

    @org.junit.Test
    public void testUpdate() throws Exception {

    }

    @org.junit.Test
    public void testFindById() throws Exception {

    }

    @org.junit.Test
    public void testFindAll() throws Exception {

    }

    @org.junit.Test
    public void testRemove() throws Exception {

    }

    @org.junit.Test
    public void testFindByLang() throws Exception {

    }
}