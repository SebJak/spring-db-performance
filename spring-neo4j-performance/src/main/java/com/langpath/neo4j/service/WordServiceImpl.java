package com.langpath.neo4j.service;

import com.common.service.api.CrudApi;
import com.common.service.api.TimeLogger;
import com.langpath.neo4j.model.Word;
import com.langpath.neo4j.repositories.WordRepository;
import common.model.enums.Count;
import common.model.enums.Language;
import org.neo4j.helpers.collection.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-04-12.
 */
@Service
public class WordServiceImpl implements CrudApi<Word, Long> {

    @Autowired
    private WordRepository repository;

    @Autowired
    @Qualifier("neo4jTimeLogger")
    private TimeLogger timeLogger;

    @Override
    public Optional<Word> save(Word word) {
        final String methodName = "SAVE";
        timeLogger.start();
        Optional<Word> saved = Optional.ofNullable(repository.save(word));
        if(saved.isPresent()) {
            timeLogger.logTime(methodName, Count.ONE.getCount());
        }
        return saved;
    }

    @Override
    public Optional<Collection<Word>> save(Iterable<Word> words) {
        final String methodName = "SAVE";
        timeLogger.start();
        Optional<Collection<Word>> saved = Optional.ofNullable(Iterables.toList(repository.save(words))); //TODO check empty
        saved.ifPresent(savedWords-> timeLogger.logTime(methodName, savedWords.size()));
        return saved;
    }

    @Transactional
    @Override
    public Optional<Word> update(Word word) {
        final String methodName = "UPDATE";
        timeLogger.start();
        Optional<Word> updated = Optional.ofNullable(repository.save(word));
        updated.ifPresent(updatedWord-> timeLogger.logTime(methodName, Count.ONE.getCount()));
        return updated;
    }

    @Override
    public Optional<Word> findById(Long id) {
        final String methodName = "SELECT_BY_ID";
        timeLogger.start();
        Optional<Word> searchResult = Optional.ofNullable(repository.findOne(id));
        searchResult.ifPresent((result) -> timeLogger.logTime(methodName, Count.ONE.getCount()));
        return searchResult;
    }

    @Override
    public Optional<Collection<Word>> findAll() {
        final String methodName = "SELECT_ALL";
        timeLogger.start();
        Optional<Collection<Word>> searchResults = Optional.ofNullable(Iterables.toList(repository.findAll())); //TODO check empty result
        searchResults.ifPresent((results) -> timeLogger.logTime(methodName, results.size()));
        return searchResults;
    }

    @Override
    public Boolean remove(Word word) {
        final String methodName = "REMOVE";
        timeLogger.start();
        repository.delete(word);
        timeLogger.logTime(methodName, Count.ONE.getCount());
        return Boolean.TRUE;
    }

    @Override
    public Optional<Collection<Word>> findByIds(Collection<Long> ids) {
        return null;
    }

}
