package com.langpath.service.impl;

import com.langpath.Application;
import com.langpath.data.model.entity.word.Word;
import com.langpath.service.util.FileReaderUtil;
import com.service.api.CrudApi;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sebastian on 2016-03-18.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@ActiveProfiles(value = "test")
public class WordServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(WordServiceTest.class);

    @Autowired
    @Qualifier("wordCrudService")
    private CrudApi<Word,Long> wordService;

    @Autowired
    private FileReaderUtil utils;

    @BeforeClass
    public static void init() {
        logger.info("Init");
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

        //Then we can updateOne.
        Collection<Word> wordsToUpdate = savedWords.get();
        wordsToUpdate.forEach(word -> word.setValue(updateValue));
        wordsToUpdate.forEach(word -> wordService.update(word).ifPresent(w -> assertEquals("Should be updated", updateValue, w.getValue())));

    }

    @Test
    public void testFindById() throws Exception {
        Collection<Word> savedWords = saveWords(1).get();
        savedWords.forEach(word -> assertEquals("Should value be present", true ,wordService.findById(word.getId()).isPresent()));
    }

    @Test
    public void testFindAll() throws Exception {
        saveWords(1);
        assertEquals("Should be something in database", true, wordService.findAll().isPresent());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testRemove() throws Exception {
        Collection<Word> savedWords = saveWords(1).get();
        savedWords.forEach(word -> assertEquals("Should not remove because foreign key", Boolean.TRUE, wordService.remove(word)));
    }

   // @Test //??????
    public void testRemoveOne() throws Exception {
        Collection<Word> savedWords = saveWords(1).get(); //assertEquals("Should be removed", Boolean.TRUE, wordService.remove(word))
    }

    private Collection<Word> getWords(int count) {
        //TODO
        //Collection<Word> words = utils.readWords(count);
        return null;
    }

    private Optional<Collection<Word>> saveWords(int count) {
        Collection<Word> wordsCouple = getWords(count);
        //Optional<Collection<Word>> savedWords = wordService.save(wordsCouple);
        //assertEquals("Should be present", true, savedWords.isPresent());
        return null;
    }
}