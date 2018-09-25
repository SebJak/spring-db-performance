package com.langpath.service.impl;

import com.langpath.service.api.WordServiceApi;
import com.langpath.data.model.entity.word.Word;
import com.model_old.enums.Language;
import com.langpath.data.repositories.WordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
@Service
public class WordService implements WordServiceApi {

    private static final Logger logger = LoggerFactory.getLogger(WordService.class);

    @Autowired
    private WordRepository repository;

    @Autowired
    @Qualifier("sqlTimeLogger")
    private TimeLogger timeLogger;

    @Override
    public Optional<Collection<Word>> findByLang(Language lang) {
        final String methodName = "SELECT_BY_LANG";
        timeLogger.start();
        Optional<Collection<Word>> searchResults = Optional.ofNullable(repository.findByLang(lang));
        searchResults.ifPresent(results -> timeLogger.logTime(methodName,results.size()));
        return searchResults;
    }


}
