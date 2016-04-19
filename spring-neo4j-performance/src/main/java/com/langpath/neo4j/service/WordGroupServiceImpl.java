package com.langpath.neo4j.service;

import com.common.service.api.CrudApi;
import com.common.service.api.TimeLogger;
import com.google.common.collect.Iterables;
import com.langpath.neo4j.model.WordGroup;
import com.langpath.neo4j.repositories.WordGroupRepository;
import common.model.enums.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-04-12.
 */
@Service("wordGroupService")
public class WordGroupServiceImpl implements CrudApi<WordGroup, Long> {

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
    public Optional<Collection<WordGroup>> save(Iterable<WordGroup> wordGroups) {
        final String method = "SAVE";
        timeLogger.start();
        Optional<Iterable<WordGroup>> saved = Optional.of(repository.save(wordGroups));
        if(saved.isPresent()){
            timeLogger.logTime(method, Iterables.size(saved.get()));
        }
        return null; //Fixme improve to return collection or iterable, make decision???????.
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
    public Optional<Collection<WordGroup>> findAll() {  //FIXME prepare logic for iterator
        final String method = "SELECT_ALL";
        timeLogger.start();
//        Optional<List<WordGroup>> found = Optional.of(new ArrayList<>(repository.findAll()));
//        if(found.isPresent()){
//            timeLogger.logTime(method, found.get().size());
//        }
        return null;
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
    public Optional<Collection<WordGroup>> findByIds(Collection<Long> ids) { //FIXME
        return null;
    }

}
