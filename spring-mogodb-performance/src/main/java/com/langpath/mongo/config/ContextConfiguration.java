package com.langpath.mongo.config;

import com.service.api.CrudApi;
import com.service.impl.CrudImpl;
import com.service.impl.FileReaderUtil;
import com.langpath.mongo.model.User;
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
    private Environment env;

    @Bean(name="userCrudService")
    public CrudApi<User, String> getUserCrudService(@Autowired UserRepository userRepository,
                                                    @Autowired  @Qualifier("mongoTimeLogger") TimeLogger timeLogger) {
        return new CrudImpl<>(userRepository, timeLogger);
    }

    @Bean(name="wordGroupCrudService")
    public CrudApi<WordGroup, String> getWordGroupCrudService(@Autowired WordGroupRepository wordGroupRepository,
                                                              @Autowired  @Qualifier("mongoTimeLogger") TimeLogger timeLogger) {
        return new CrudImpl<>(wordGroupRepository, timeLogger);
    }

    @Bean(name = "mongoTimeLogger")
    public TimeLogger getTimeLogger() {
        return new TimeLogger(env.getRequiredProperty("mongoTime.log"));
    }

    @Bean(name = "FileReaderUtil")
    public FileReaderUtil getFileReaderUtil() {
        return new FileReaderUtil(env.getRequiredProperty("words.fileName"));
    }
}
