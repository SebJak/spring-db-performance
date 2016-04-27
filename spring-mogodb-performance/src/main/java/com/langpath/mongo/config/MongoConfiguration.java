package com.langpath.mongo.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

/**
 * Created by Sebastian on 2016-04-27.
 */
@Configurable
@ComponentScan("com.langpath.service.mongo")
@EnableMongoRepositories(basePackages = "com.langpath.mongo.repository")
public class MongoConfiguration {

    private static final String name = "langpath";

    private static final String url = "127.0.0.1";

    private static final int port = 27017;

    @Bean
    public String getDatabaseName() {
        return name;
    }

    @Bean
    public MongoClient mongo() throws UnknownHostException {
        return new MongoClient(url, port);
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
        return new SimpleMongoDbFactory(mongo(), getDatabaseName());
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return  mongoTemplate;
    }

}
