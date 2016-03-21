package com.langpath.service.impl;

import com.langpath.service.api.WordServiceApi;
import com.langpath.sql.model.entity.word.Word;
import com.langpath.sql.model.enums.Language;

import java.util.Collection;

/**
 * Created by Sebastian on 2016-03-18.
 */
public class WordService implements WordServiceApi {

    @Override
    public Word save(Word word) {
        return null;
    }

    @Override
    public Word update(Word word) {
        return null;
    }

    @Override
    public Word findById(Long id) {
        return null;
    }

    @Override
    public Collection<Word> findAll() {
        return null;
    }

    @Override
    public Boolean remove(Word word) {
        return null;
    }

    @Override
    public Collection<Word> findByLang(Language lang) {
        return null;
    }
}
