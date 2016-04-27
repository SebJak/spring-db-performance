package com.langpath.mongo.repository;

import com.langpath.mongo.model.WordGroup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sebastian on 2016-04-27.
 */
@Repository
public interface WordGroupRepository extends MongoRepository<WordGroup, Long> {
}
