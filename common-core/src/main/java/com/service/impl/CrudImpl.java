package com.service.impl;

import com.codahale.metrics.annotation.Timed;
import com.service.api.CrudApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.Optional;

import static java.util.Optional.of;

/**
 * Created by Sebastian on 2016-04-23.
 */

public class CrudImpl<K, T extends Serializable> implements CrudApi<K, T> {

    private final Logger logger = LoggerFactory.getLogger(CrudImpl.class);

    private CrudRepository<K, T> repository;

    @Autowired
    public CrudImpl(CrudRepository<K, T> repository) {
        logger.info("Init CrudImpl with properties: " + repository.getClass());
        this.repository = repository;
    }


    @Override
    @Timed(absolute = true, name = "saveOne")
    public Optional<K> save(K entity) {
        return of(repository.save(entity));
    }

    @Override
    @Timed(absolute = true, name = "saveCollection")
    public Optional<Iterable<K>> save(Iterable<K> entities) {
        return of(repository.saveAll(entities));
    }

    @Override
    @Timed(absolute = true, name = "updateOne")
    public Optional<K> update(K entity) {
       return of(repository.save(entity));
    }

    @Override
    @Timed(absolute = true, name = "updateOne")
    public Optional<Iterable<K>> update(Iterable<K> entities) {
        return of(repository.saveAll(entities));
    }

    @Override
    @Timed(absolute = true, name = "findById")
    public Optional<K> findById(T id) {
        return repository.findById(id);
    }

    @Override
    @Timed(absolute = true, name = "findAll")
    public Optional<Iterable<K>> findAll() { //FIXME
        return of(repository.findAll());
    }

    @Override
    @Timed(absolute = true, name = "remove")
    public Boolean remove(K entity) {
        repository.delete(entity);
        return true;
    }
}
