package com.langpath.neo4j.repositories;

import com.langpath.neo4j.model.Word;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Sebastian on 2016-04-12.
 */
@Repository
@Transactional
public interface WordRepository extends GraphRepository<Word> {

    @Query("MATCH (word:Word) WHERE  id(word)={0} SET word.badAnswers = word.badAnswers + 1")
    void increaseBadAnswers(long id);
}
