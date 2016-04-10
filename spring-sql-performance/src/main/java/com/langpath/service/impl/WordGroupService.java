package com.langpath.service.impl;

import com.langpath.data.model.entity.word.WordGroup;
import com.langpath.data.model.helps.AggregationWordGroup;
import com.langpath.data.repositories.WordGroupRepository;

import com.langpath.service.api.WordGroupServiceApi;

import com.langpath.util.api.TimeLogger;
import com.langpath.util.enums.Count;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
@Service
public class WordGroupService implements WordGroupServiceApi{

    private static final Logger logger = LoggerFactory.getLogger(WordGroupService.class);

    @Autowired
    private WordGroupRepository repository;

    @Autowired
    @Qualifier("sqlTimeLogger")
    private TimeLogger timeLogger;

    @Override
    public Optional<WordGroup> save(WordGroup wordGroup) {
        final String method = "SAVE";
        timeLogger.start();
        Optional<WordGroup> saved = Optional.of(repository.save(wordGroup));
        if(saved.isPresent()){
            timeLogger.logTime(method, Count.ONE.getCount());
        }
        return saved;
    }

    @Override
    public Optional<Collection<WordGroup>> save(Iterable<WordGroup> wordGroup) {
        final String method = "SAVE";
        timeLogger.start();
        Optional<Collection<WordGroup>> saved = Optional.of(repository.save(wordGroup));
        if(saved.isPresent()){
            timeLogger.logTime(method, saved.get().size());
        }
        return saved;
    }

    @Override
    public Optional<WordGroup> update(WordGroup wordGroup) {
        final String method = "UPDATE";
        timeLogger.start();
        Optional<WordGroup> updated = Optional.of(repository.save(wordGroup));
        if(updated.isPresent()){
            timeLogger.logTime(method, Count.ONE.getCount());
        }
        return updated;
    }

    @Override
    public Optional<WordGroup> findById(Long id) {
        final String method = "SELECT_BY_ID";
        timeLogger.start();
        Optional<WordGroup> found = Optional.of(repository.findOne(id));
        if(found.isPresent()){
            timeLogger.logTime(method, Count.ONE.getCount());
        }
        return found;

    }

    @Override
    public Optional<Collection<WordGroup>> findAll() {
        final String method = "SELECT_ALL";
        timeLogger.start();
        Optional<Collection<WordGroup>> found = Optional.of(repository.findAll());
        if(found.isPresent()){
            timeLogger.logTime(method, found.get().size());
        }
        return found;
    }

    @Override
    public Boolean remove(WordGroup wordGroup) {
        final String method = "SELECT_BY_ID";
        timeLogger.start();
        repository.delete(wordGroup);
        timeLogger.logTime(method, Count.ONE.getCount());
        return Boolean.TRUE;
    }

    @Override
    public Optional<Collection<WordGroup>> findByIds(Collection<Long> ids) {
        return null;
    }

    public Optional<WordGroup> getRandom() {
        List<WordGroup> wordGroupList = repository.findAll();
        if(wordGroupList != null && wordGroupList.size()>0) {
            return Optional.of(wordGroupList.get(0));
        }
        return Optional.empty();
    }

    @Override
    public Collection<AggregationWordGroup> getAggregationWordGroup() {
        final String method = "AGGREGATION_1";
        timeLogger.start();
        Collection<AggregationWordGroup> results = repository.getAggregation();
        timeLogger.logTime(method,results.size());
        return results;
    }
}
