package com.langpath.neo4j.service;

import com.common.service.api.CrudApi;
import com.langpath.neo4j.model.WordGroup;
import com.langpath.neo4j.repositories.WordGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Optional<WordGroup> save(WordGroup entity) {
        return null;
    }

    @Override
    public Optional<Collection<WordGroup>> save(Iterable<WordGroup> entities) {
        return null;
    }

    @Override
    public Optional<WordGroup> update(WordGroup entity) {
        return null;
    }

    @Override
    public Optional<WordGroup> findById(Long id) {
        return null;
    }

    @Override
    public Optional<Collection<WordGroup>> findAll() {
        return null;
    }

    @Override
    public Boolean remove(WordGroup entity) {
        return null;
    }

    @Override
    public Optional<Collection<WordGroup>> findByIds(Collection<Long> ids) {
        return null;
    }
}
