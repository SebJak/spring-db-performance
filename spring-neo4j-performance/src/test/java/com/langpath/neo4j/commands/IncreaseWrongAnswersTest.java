package com.langpath.neo4j.commands;

import com.langpath.neo4j.Neo4jApplication;
import com.langpath.neo4j.model.Word;
import com.langpath.neo4j.repositories.WordRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by root on 11.10.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Neo4jApplication.class)
@ActiveProfiles(value = "test")
public class IncreaseWrongAnswersTest {
    @Autowired
    IncreaseWrongAnswers increaseWrongAnswers;

    @Autowired
    WordRepository wordRepository;

    @Test
    public void increaseWrongAnswer() throws Exception {
        Page<Word> wordsPg = wordRepository.findAll(new PageRequest(1,100));
        wordsPg.forEach(word -> {
            increaseWrongAnswers.increaseWrongAnswer(word);
        });

    }

    @Test
    public void increaseWrongAnswerById() throws Exception {
        Page<Word> wordsPg = wordRepository.findAll(new PageRequest(1,100));
        wordsPg.forEach(word -> {
            increaseWrongAnswers.increaseWrongAnswer(word.getId());
        });
    }



}