package com.langpath.commands;

import com.langpath.Application;
import com.langpath.data.model.entity.word.Word;
import com.langpath.data.repositories.WordRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by root on 11.10.16.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@ActiveProfiles(value = "test")
public class IncreaseWrongAnswersTest {

    @Autowired
    IncreaseWrongAnswers increaseWrongAnswers;

    @Autowired
    WordRepository wordRepository;

    @Test
    public void shouldIncreaseWrongAnswers(){
        for(int i=0;i<500;i++) {
            Page<Word> wordsPage = wordRepository.findAll(new PageRequest(i,5));
                wordsPage.forEach(word -> {
                    int last = word.getWrongAnswers();
                    increaseWrongAnswers.increaseWrongAnswers(word.getId());
                    //assertTrue(last < ); //todo add assert
                });
        }
    }

}