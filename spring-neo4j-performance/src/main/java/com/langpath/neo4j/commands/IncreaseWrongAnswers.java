package com.langpath.neo4j.commands;

import com.langpath.neo4j.model.Word;
import com.langpath.neo4j.repositories.WordRepository;
import com.model_old.enums.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by root on 11.10.16.
 */
@Service
public class IncreaseWrongAnswers {

    @Autowired
    WordRepository wordRepository;

    @Autowired
    @Qualifier("neo4jTimeLogger")
    private TimeLogger timeLogger;

    public void increaseWrongAnswer(Word word) {
        final String METHOD = "UPDATE";
        timeLogger.start();
        word.setBadAnswers(word.getBadAnswers()+1);
        wordRepository.save(word);
        timeLogger.logTime(METHOD, Count.ONE.getCount());
    }

    public void increaseWrongAnswer(long wordId) {
        final String METHOD = "UPDATE";
        timeLogger.start();
        wordRepository.increaseBadAnswers(wordId);
        timeLogger.logTime(METHOD, Count.ONE.getCount());
    }
}
