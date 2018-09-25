package com.langpath.neo4j.config;

import com.service.api.CrudApi;
import com.service.impl.CrudImpl;
import com.service.impl.FileReaderUtil;
import com.langpath.neo4j.model.User;
import com.langpath.neo4j.model.Word;
import com.langpath.neo4j.model.WordGroup;
import com.langpath.neo4j.repositories.UserRepository;
import com.langpath.neo4j.repositories.WordGroupRepository;
import com.langpath.neo4j.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

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
    private Environment env;

//    @Autowired
//    @Qualifier("neo4jTimeLogger")
//    private TimeLogger timeLogger;

    @Bean(name = "neo4jTimeLogger")
    public TimeLogger getTimeLogger() {
        return new TimeLogger(env.getRequiredProperty("neo4jTime.log"));
    }

    @Bean(name="userCrudService")
    public CrudApi<User, Long> getUserCrudService() {
        return new CrudImpl<>(userRepository, getTimeLogger());
    }

    @Bean(name="wordCrudService")
    public CrudApi<Word, Long> getWordCrudService() {
        return new CrudImpl<>(wordRepository, getTimeLogger());
    }

    @Bean(name="wordGroupCrudService")
    public CrudApi<WordGroup, Long> getWordGroupCrudService() {
        return new CrudImpl<>(wordGroupRepository, getTimeLogger());
    }

    @Bean(name="fileReaderUtil")
    public FileReaderUtil getFileReadeUtil() {
        return new FileReaderUtil(env.getRequiredProperty("words.fileName"));
    }


}
