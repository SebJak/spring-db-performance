package com.langpath.commands;

import com.langpath.data.repositories.WordGroupRepository;
import com.model_old.enums.Count;
import org.springframework.stereotype.Service;

/**
 * Created by root on 11.10.16.
 */
@Service
public class RemoveWordGroup extends AbstractCommand {

    private WordGroupRepository repository;

    public RemoveWordGroup(WordGroupRepository repository) {
        this.repository = repository;
    }

    void removeWordGroup(final long wordGroupId) {
        final String METHOD = "DELETE";
        timeLogger.start();
        repository.deleteWordGroup(wordGroupId);
        timeLogger.logTime(METHOD, Count.ONE.getCount());
    }

}
