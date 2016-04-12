package com.langpath.neo4j.service;

import com.common.service.api.CrudApi;
import com.langpath.neo4j.model.Word;
import com.langpath.neo4j.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-04-12.
 */
@Service
public class WordServiceImpl implements CrudApi<Word, Long> {

    @Autowired
    private WordRepository repository;

    @Override
    public Optional<Word> save(Word entity) {
        return null;
    }

    @Override
    public Optional<Collection<Word>> save(Iterable<Word> entities) {
        return null;
    }

    @Override
    public Optional<Word> update(Word entity) {
        return null;
    }

    @Override
    public Optional<Word> findById(Long id) {
        return null;
    }

    @Override
    public Optional<Collection<Word>> findAll() {
        return null;
    }

    @Override
    public Boolean remove(Word entity) {
        return null;
    }

    @Override
    public Optional<Collection<Word>> findByIds(Collection<Long> ids) {
        return null;
    }
}
