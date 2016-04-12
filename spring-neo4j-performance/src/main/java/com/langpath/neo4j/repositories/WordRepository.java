package com.langpath.neo4j.repositories;

import com.langpath.neo4j.model.Word;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sebastian on 2016-04-12.
 */
@Repository
public interface WordRepository extends GraphRepository<Word> {

}
