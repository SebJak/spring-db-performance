package com.langpath.service.impl;

import com.langpath.service.api.WordServiceApi;
import com.langpath.sql.model.entity.word.Word;
import com.langpath.sql.model.enums.Language;
import com.langpath.sql.repositories.WordRepository;
import com.langpath.util.impl.SqlTimeLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
@Service
public class WordService implements WordServiceApi {

    @Autowired
    private WordRepository repository;

    @Autowired
    private SqlTimeLogger timeLogger;

    @Override
    public Optional<Word> save(Word word) {
        final String methodName = "Save";
        timeLogger.start();
        Optional<Word> saved = Optional.ofNullable(repository.save(word));
        if(saved.isPresent()) {
            timeLogger.logTime(methodName, 1);
        }
        return saved;
    }

    @Override
    public Optional<Collection<Word>> save(Iterable<Word> words) {
        final String methodName = "Save";
        timeLogger.start();
        Optional<Collection<Word>> saved = Optional.ofNullable(repository.save(words));
        if(saved.isPresent()) {
            timeLogger.logTime(methodName, saved.get().size());
        }
        return saved;
    }

    @Override
    public Optional<Word> update(Word word) {
        Optional<Word> updated = Optional.ofNullable(repository.save(word));
        return updated;
    }

    @Override
    public Optional<Word> findById(Long id) {
        Optional<Word> search = Optional.ofNullable(repository.findOne(id));
        return search;
    }

    @Override
    public Optional<Collection<Word>> findAll() {
        Optional<Collection<Word>> search = Optional.ofNullable(repository.findAll());
        return search;
    }

    @Override
    public Boolean remove(Word word) {
        repository.delete(word);
        return Boolean.TRUE;
    }

    @Override
    public Optional<Collection<Word>> findByLang(Language lang) {
        Optional<Collection<Word>> search = Optional.ofNullable(repository.findByLang(lang));
        return search;
    }
}
