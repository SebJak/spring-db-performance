package com.langpath.neo4j.config;

import com.common.service.api.CrudApi;
import com.common.service.api.TimeLogger;
import com.common.service.impl.CrudImpl;
import com.langpath.neo4j.model.User;
import com.langpath.neo4j.model.Word;
import com.langpath.neo4j.model.WordGroup;
import com.langpath.neo4j.repositories.UserRepository;
import com.langpath.neo4j.repositories.WordGroupRepository;
import com.langpath.neo4j.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sebastian on 2016-04-23.
 */
@Configuration
public class ContextConfiguration {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private WordGroupRepository wordGroupRepository;


    @Autowired
    @Qualifier("neo4jTimeLogger")
    private TimeLogger timeLogger;

    @Bean(name="userCrudService")
    public CrudApi<User, Long> getUserCrudService() {
        return new CrudImpl<>(userRepository, timeLogger);
    }

    @Bean(name="wordCrudService")
    public CrudApi<Word, Long> getWordCrudService() {
        return new CrudImpl<>(wordRepository, timeLogger);
    }

    @Bean(name="wordGroupCrudService")
    public CrudApi<WordGroup, Long> getWordGroupCrudService() {
        return new CrudImpl<>(wordGroupRepository, timeLogger);
    }
}
