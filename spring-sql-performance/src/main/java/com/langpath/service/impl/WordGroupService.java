package com.langpath.service.impl;

import com.langpath.data.model.entity.word.WordGroup;
import com.langpath.data.model.helps.AggregationWordGroup;
import com.langpath.data.repositories.WordGroupRepository;

import com.langpath.service.api.WordGroupServiceApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
@Service
public class WordGroupService implements WordGroupServiceApi{

    @Autowired
    private WordGroupRepository repository;

    @Override
    public Optional<WordGroup> save(WordGroup wordGroup) {
        return Optional.of(repository.save(wordGroup));
    }

    @Override
    public Optional<Collection<WordGroup>> save(Iterable<WordGroup> word) {
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

    public Optional<WordGroup> getRandom() {
        List<WordGroup> wordGroupList = repository.findAll();
        if(wordGroupList != null && wordGroupList.size()>0) {
            return Optional.of(wordGroupList.get(0));
        }
        return Optional.empty();
    }

    @Override
    public Collection<AggregationWordGroup> getAggregationWordGroup() {
       return repository.getAggregation();
    }
}
