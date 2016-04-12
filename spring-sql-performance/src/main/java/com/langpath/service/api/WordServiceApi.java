package com.langpath.service.api;

import com.common.service.api.CrudApi;
import com.langpath.data.model.entity.word.Word;
import common.model.enums.Language;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
public interface WordServiceApi extends CrudApi<Word, Long> {

    Optional<Collection<Word>> findByLang(Language lang);
}
