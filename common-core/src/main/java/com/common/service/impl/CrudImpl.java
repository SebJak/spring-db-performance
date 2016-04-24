package com.common.service.impl;

import com.common.service.api.CrudApi;
import com.common.service.api.TimeLogger;
import com.google.common.collect.Iterables;
import common.model.enums.Count;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-04-23.
 */
public class CrudImpl<K, T extends Serializable> implements CrudApi<K, T> {

    private final Logger logger = LoggerFactory.getLogger(CrudImpl.class);

    private PagingAndSortingRepository<K, T> repository;


    private TimeLogger timeLogger;

    @Autowired
    public CrudImpl(PagingAndSortingRepository<K, T> repository, TimeLogger timeLogger) {
        logger.info("Init CrudImpl with properties: " + repository.getClass() + timeLogger.getClass());
        this.repository = repository;
        this.timeLogger = timeLogger;
    }


    @Override
    public Optional<K> save(K entity) {
        final String methodName = "SAVE";
        timeLogger.start();
        Optional<K> saved = Optional.ofNullable(repository.save(entity));
        if(saved.isPresent()) {
            timeLogger.logTime(methodName, Count.ONE.getCount());
        }
        return saved;
    }

    @Override
    public Optional<Iterable<K>> save(Iterable<K> entities) {
        final String methodName = "SAVE";
        timeLogger.start();
        Optional<Iterable<K>> saved = Optional.ofNullable(repository.save(entities)); //TODO test if return is empty
        if(saved.isPresent()) {
            timeLogger.logTime(methodName, Iterables.size(saved.get()));
        }
        return saved;
    }

    @Override
    public Optional<K> update(K entity) {
        final String methodName = "UPDATE";
        timeLogger.start();
        Optional<K> update = Optional.ofNullable(repository.save(entity));
        if(update.isPresent()) {
            timeLogger.logTime(methodName, Count.ONE.getCount());
        }
        return update;
    }

    @Override
    public Optional<K> findById(T id) {
        final String methodName = "SELECT_BY_ID";
        timeLogger.start();
        Optional<K> found = Optional.ofNullable(repository.findOne(id));
        if(found.isPresent()) {
            timeLogger.logTime(methodName, Count.ONE.getCount());
        }
        return found;
    }

    @Override
    public Optional<Iterable<K>> findAll() { //FIXME
        final String methodName = "SELECT_ALL";
        timeLogger.start();
        Optional<Iterable<K>> found = Optional.ofNullable(repository.findAll());
        if(found.isPresent()) {
            timeLogger.logTime(methodName,  Iterables.size(found.get()));
        }
        return found;
    }

    @Override
    public Boolean remove(K entity) {
        final String methodName = "DELETE";
        timeLogger.start();
        repository.delete(entity);
        timeLogger.logTime(methodName, Count.ONE.getCount());
        return Boolean.TRUE;
    }
}
