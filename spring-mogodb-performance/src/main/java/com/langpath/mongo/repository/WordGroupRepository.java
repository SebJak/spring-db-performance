package com.langpath.mongo.repository;

import com.langpath.mongo.model.WordGroup;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by Sebastian on 2016-04-27.
 */
@Repository
public interface WordGroupRepository extends MongoRepository<WordGroup, String> {

    WordGroup findByIdInOrderByFishCardsMeaningsWrongAnswers(Set<ObjectId> wordGroup);

    /*
    findByIdInOrderByFishCardsMeaningWrongAnswers
    db.foo.aggregate(
  { $group: {
        _id : "$name",
        data_min: {$min: "$track.end"},
        data_max: {$max: "$track.start"}
     }
  },
  {
    $project:{
        _id: "$_id",
        score: { $subtract : [
            {$cond:[{$gt:["$data_max",1]},"$data_max",1]},
            {$cond:[{$lt:["$data_min",4]},"$data_min",4]}
        ]}
    }
  }
)
     */
}
