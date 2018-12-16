package com.langpath.mongo.aggregation;

import com.mongodb.BasicDBObject;
import com.mongodb.operation.AggregateOperation;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    MongoTemplate mongoTemplate;

    public void getDashboardData(){
        GroupOperation groupOperation = new GroupOperation(Fields.fields("time", "system")).count().as("count");
        GroupOperation groupSecond = new GroupOperation(Fields.fields("time")).push(new BasicDBObject("system", "$_id.system").append("count", "$count")).as("systems");
        Aggregation aggregation = Aggregation.newAggregation(groupOperation, groupSecond);

        AggregationResults<Document> result = mongoTemplate.aggregate(aggregation,"items", Document.class);
        result.getMappedResults();
    }
}
