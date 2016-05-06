package com.langpath.mongo.config;

import com.common.service.api.CrudApi;
import com.common.service.api.TimeLogger;
import com.common.service.impl.CrudImpl;
import com.langpath.mongo.model.User;
import com.langpath.mongo.model.Word;
import com.langpath.mongo.model.WordGroup;
import com.langpath.mongo.repository.UserRepository;
import com.langpath.mongo.repository.WordGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by Sebastian on 2016-04-27.
 */
@Configuration
public class ContextConfiguration {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WordGroupRepository wordGroupRepository;

    @Autowired
    private Environment env;

    @Autowired
    @Qualifier("mongoTimeLogger")
    private TimeLogger timeLogger;

    @Bean(name="userCrudService")
    public CrudApi<User, Long> getUserCrudService() {
        return new CrudImpl<>(userRepository, timeLogger);
    }

    @Bean(name="wordGroupCrudService")
    public CrudApi<WordGroup, Long> getWordGroupCrudService() {
        return new CrudImpl<>(wordGroupRepository, timeLogger);
    }

    @Bean(name = "mongoTimeLogger")
    public TimeLogger getTimeLogger() {
        return new TimeLogger(env.getRequiredProperty("mongoTime.log"));
    }
}
