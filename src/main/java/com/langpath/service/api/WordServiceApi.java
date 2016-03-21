package com.langpath.service.api;

import com.langpath.sql.model.entity.word.Word;
import com.langpath.sql.model.enums.Language;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
public interface WordServiceApi extends CommonApi<Word, Long> {

    Optional<Collection<Word>> findByLang(Language lang);
}
