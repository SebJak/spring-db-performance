package com.langpath.neo4j.commands;

import com.langpath.neo4j.commands.help.AbstractCommand;
import com.langpath.neo4j.model.aggregation.WorstAnsweredWord;
import com.langpath.neo4j.repositories.UserRepository;
import com.model_old.enums.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by root on 13.10.16.
 */
@Service
public class FindWorstAnsweredWord extends AbstractCommand{

    @Autowired
    private UserRepository userRepository;

    public WorstAnsweredWord getWorstAnsweredWord(long userId) {
        final String METHOD = "WORST_WORD";
        timeLogger.start();
        WorstAnsweredWord worstAnsweredWord = userRepository.getWorstWord(userId);
        timeLogger.logTime(METHOD, Count.ONE.getCount());
        return worstAnsweredWord;
    }
}
