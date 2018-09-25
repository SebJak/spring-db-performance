package com.langpath.neo4j.repositories;

import com.langpath.neo4j.model.User;
import com.langpath.neo4j.model.aggregation.WorstAnsweredWord;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.annotation.QueryResult;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by Sebastian on 2016-04-12.
 */
@Repository
public interface UserRepository extends GraphRepository<User> {

    @Query("MATCH (p:Person)-[r:WORD_GROUPS]->(wg:WordGroup)-[r2:WORD_GROUP]->(w:Word)"+
            "WHERE id(p) = {0} "+
            "RETURN id(p),id(wg), w.value, w.badAnswers "+
            "ORDER BY w.badAnswers DESC LIMIT 1")
    WorstAnsweredWord getWorstWord(long userId);


}
