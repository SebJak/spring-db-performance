package com.langpath.mongo.config;

import com.service.api.CrudApi;
import com.service.impl.CrudImpl;
import com.langpath.mongo.model.User;
import com.langpath.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Sebastian on 2016-04-27.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.langpath.mongo.repository")
public class ContextConfiguration {

    @Bean(name="userCrudService")
    public CrudApi<User, String> getUserCrudService(@Autowired UserRepository userRepository) {
        return new CrudImpl<>(userRepository);
    }

}
