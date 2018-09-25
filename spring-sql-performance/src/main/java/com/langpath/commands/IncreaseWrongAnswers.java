package com.langpath.commands;

import com.langpath.data.repositories.WordRepository;
import com.model_old.enums.Count;
import org.springframework.stereotype.Service;

/**
 * Created by root on 11.10.16.
 */
@Service
public class IncreaseWrongAnswers extends AbstractCommand {

    private WordRepository wordRepository;

    public IncreaseWrongAnswers(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    void increaseWrongAnswers(final long wordId) {
        final String METHOD_NAME = "UPDATE";
        timeLogger.start();
        wordRepository.increaseWrongAnswers(wordId);
        timeLogger.logTime(METHOD_NAME, Count.ONE.getCount());
    }
}
