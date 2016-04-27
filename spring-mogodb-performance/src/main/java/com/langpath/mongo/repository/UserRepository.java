package com.langpath.mongo.repository;

import com.langpath.mongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sebastian on 2016-04-27.
 */
@Repository
public interface UserRepository extends MongoRepository<User, Long>{

}
