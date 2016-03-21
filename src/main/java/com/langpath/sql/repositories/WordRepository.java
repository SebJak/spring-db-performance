package com.langpath.sql.repositories;

import com.langpath.sql.model.entity.word.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sebastian on 2016-03-18.
 */
@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

}
