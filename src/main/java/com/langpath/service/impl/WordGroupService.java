package com.langpath.service.impl;

import com.langpath.service.api.WordGroupServiceApi;
import com.langpath.sql.model.entity.word.WordGroup;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
public class WordGroupService implements WordGroupServiceApi{
    @Override
    public Optional<WordGroup> save(WordGroup word) {
        return null;
    }

    @Override
    public Optional<WordGroup> update(WordGroup word) {
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
    public Boolean remove(WordGroup word) {
        return null;
    }
}
