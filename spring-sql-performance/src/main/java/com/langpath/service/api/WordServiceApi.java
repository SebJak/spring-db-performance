package com.langpath.service.api;

import com.langpath.data.model.entity.word.Word;
import com.langpath.data.model.enums.Language;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
public interface WordServiceApi extends CommonApi<Word, Long> {

    Optional<Collection<Word>> findByLang(Language lang);
}
