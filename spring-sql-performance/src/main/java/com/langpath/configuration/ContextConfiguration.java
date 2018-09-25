package com.langpath.configuration;

import com.service.api.CrudApi;
import com.service.impl.CrudImpl;
import com.langpath.data.model.entity.user.User;
import com.langpath.data.model.entity.word.Word;
import com.langpath.data.model.entity.word.WordGroup;
import com.langpath.data.repositories.UserRepository;
import com.langpath.data.repositories.WordGroupRepository;
import com.langpath.data.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Sebastian on 2016-04-23.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.langpath.data.repositories")
@ComponentScan(basePackages = "com.langpath")
public class ContextConfiguration {

    @Autowired
    private Environment env;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private WordGroupRepository wordGroupRepository;

    @Autowired
    @Qualifier("sqlTimeLogger")
    private TimeLogger timeLogger;

    @Bean(name = "userCrudService")
    CrudApi<User, Long> getUserCrud() {
        return new CrudImpl<>(userRepository, timeLogger);
    }

    @Bean(name = "wordCrudService")
    CrudApi<Word, Long> getWordCrud() {
        return new CrudImpl<>(wordRepository, timeLogger);
    }

    @Bean(name = "wordGroupCrudService")
    CrudApi<WordGroup, Long> getWordGroupCrud() {
        return new CrudImpl<>(wordGroupRepository, timeLogger);
    }

    @Bean(name = "sqlTimeLogger")
    public TimeLogger getTimeLogger() {
        return new TimeLogger(env.getRequiredProperty("sqlTime.log"));
    }

}
