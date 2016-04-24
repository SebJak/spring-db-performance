package com.langpath.configuration;

import com.common.service.api.CrudApi;
import com.common.service.api.TimeLogger;
import com.common.service.impl.CrudImpl;
import com.langpath.data.model.entity.user.User;
import com.langpath.data.model.entity.word.Word;
import com.langpath.data.repositories.UserRepository;
import com.langpath.data.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sebastian on 2016-04-23.
 */
@Configuration
@ComponentScan(basePackages = "com.langpath")
public class ContextConfiguration {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WordRepository wordRepository;

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

}
