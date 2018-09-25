package com.langpath.service.api;

import com.langpath.data.model.entity.word.Word;
import com.model_old.enums.Language;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
public interface WordServiceApi {

    Optional<Collection<Word>> findByLang(Language lang);
}
