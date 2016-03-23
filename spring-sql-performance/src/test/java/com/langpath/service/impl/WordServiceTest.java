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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class WordServiceTest {

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
        Optional<Collection<Word>> savedWords = saveWords(1);
        savedWords.ifPresent(words -> assertEquals(2, words.size()));
    }

    @Test
    public void testUpdate() throws Exception {
        String updateValue = "updated value";
        //First we need to save:
        Optional<Collection<Word>> savedWords = saveWords(1);

        //Then we can update.
        Collection<Word> wordsToUpdate = savedWords.get();
        wordsToUpdate.forEach(word -> word.setValue(updateValue));
        wordsToUpdate.forEach(word -> assertEquals("Should value be updated", updateValue ,wordService.update(word)));

    }

    @Test
    public void testFindById() throws Exception {
        Collection<Word> savedWords = saveWords(1).get();
        savedWords.forEach(word -> assertEquals("Should value be present", true ,wordService.findById(word.getId())));
    }

    @Test
    public void testFindAll() throws Exception {
        wordService.findAll();
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testRemove() throws Exception {
        Collection<Word> savedWords = saveWords(1).get();
        savedWords.forEach(word -> assertEquals("Should not remove because foreign key", Boolean.TRUE, wordService.remove(word)));
    }

    @Test
    public void testRemoveOne() throws Exception {
        Collection<Word> savedWords = saveWords(1).get();
        savedWords.stream().filter(word-> word.getSource() == null).limit(1).forEach(word -> assertEquals("Should be removed", Boolean.TRUE ,wordService.remove(word)));
    }

    @Test
    public void testFindByLang() throws Exception {
        Collection<Word> savedWords = saveWords(1).get();
        savedWords.forEach(word -> assertEquals("Should be present", true, wordService.findByLang(word.getLang()).isPresent()));
    }

    private Collection<Word> getWords(int count) {
        Collection<Word> words = utils.readWords(count);
        return words;
    }

    private Optional<Collection<Word>> saveWords(int count) {
        Collection<Word> wordsCouple = getWords(count);
        Optional<Collection<Word>> savedWords = wordService.save(wordsCouple);
        assertEquals("Should be present", true, savedWords.isPresent());
        return savedWords;
    }
}