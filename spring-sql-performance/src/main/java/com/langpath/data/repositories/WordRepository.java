package com.langpath.data.repositories;

import com.langpath.data.model.entity.word.Word;
import com.langpath.data.model.enums.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Sebastian on 2016-03-18.
 */
@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    Collection<Word> findByLang(Language lang);


}
