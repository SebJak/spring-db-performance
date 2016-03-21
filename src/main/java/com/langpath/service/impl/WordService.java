package com.langpath.service.impl;

import com.langpath.service.api.WordServiceApi;
import com.langpath.sql.model.entity.word.Word;
import com.langpath.sql.model.enums.Language;
import com.langpath.sql.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
public class WordService implements WordServiceApi {

    @Autowired
    private WordRepository repository;

    @Override
    public Optional<Word> save(Word word) {

        return null;
    }

    @Override
    public Optional<Word> update(Word word) {
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
    public Boolean remove(Word word) {
        return null;
    }

    @Override
    public Optional<Collection<Word>> findByLang(Language lang) {
        return null;
    }
}
