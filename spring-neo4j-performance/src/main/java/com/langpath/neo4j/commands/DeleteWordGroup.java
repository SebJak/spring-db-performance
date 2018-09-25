package com.langpath.neo4j.commands;

import com.langpath.neo4j.repositories.WordGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Created by root on 12.10.16.
 */
@Service
public class DeleteWordGroup {

    @Autowired
    private WordGroupRepository wordGroupRepository;

    @Autowired
    @Lazy
    @Qualifier("neo4jTimeLogger")
    TimeLogger timeLogger;


    public void deleteWordGroup(final long id){
        timeLogger.start();
        wordGroupRepository.deleteWordGroupWithRelations(id);
        timeLogger.logTime("DELETE", 1);
    }
}
