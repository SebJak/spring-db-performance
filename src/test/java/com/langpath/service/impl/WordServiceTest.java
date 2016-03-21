package com.langpath.service.impl;

import static org.junit.Assert.*;

import com.langpath.Application;
import com.langpath.sql.model.entity.word.Word;
import com.langpath.util.FileReaderUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class WordServiceTest {

    private static final String FILE_NAME = "E:\\Workspace\\workspace_JaVa\\_mgr\\spring-sql-performance\\src\\test\\resources\\com.langpath.service.impl\\words.txt";

    @Autowired
    private WordService wordService;

    @Autowired
    private FileReaderUtil utils;

    @BeforeClass
    public static void init() {
        System.out.println("Init");
    }

    @Test
    public void testSaveOneCouple() {
        for(int i=0;i<100;i++) {
            Collection<Word> wordsCouple = utils.readWords(1);
            Optional<Collection<Word>> savedWords = wordService.save(wordsCouple);
            assertEquals("Should be present", true, savedWords.isPresent());
            savedWords.ifPresent(words -> assertEquals(2, words.size()));
        }
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testFindById() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testFindByLang() throws Exception {

    }
}