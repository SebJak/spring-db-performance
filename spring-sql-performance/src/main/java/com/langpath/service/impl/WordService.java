package com.langpath.service.impl;

import com.langpath.service.api.WordServiceApi;
import com.langpath.data.model.entity.word.Word;
import com.langpath.data.model.enums.Language;
import com.langpath.data.repositories.WordRepository;
import com.langpath.util.api.TimeLogger;
import com.langpath.util.enums.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
@Service
public class WordService implements WordServiceApi {

    @Autowired
    private WordRepository repository;

    @Autowired
    @Qualifier("sqlTimeLogger")
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
        Optional<Collection<Word>> saved = Optional.ofNullable(repository.save(words));
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
        Optional<Collection<Word>> searchResults = Optional.ofNullable(repository.findAll());
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
    public Optional<Collection<Word>> findByLang(Language lang) {
        final String methodName = "SELECT_BY_LANG";
        timeLogger.start();
        Optional<Collection<Word>> searchResults = Optional.ofNullable(repository.findByLang(lang));
        searchResults.ifPresent(results -> timeLogger.logTime(methodName,results.size()));
        return searchResults;
    }
}
