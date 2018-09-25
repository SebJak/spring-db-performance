package com.langpath.service.impl;

import com.langpath.data.repositories.UserRepository;
import com.langpath.service.api.UserServiceApi;
import com.langpath.data.model.entity.user.User;
import com.model_old.enums.Count;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by sjakowski on 2016-03-16.
 */
@Service
public class UserService implements UserServiceApi {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    @Qualifier("sqlTimeLogger")
    private TimeLogger timeLogger;


    @Override
    public User saveOne(User user) {
        final String methodName = "SAVE";
        timeLogger.start();
        User saved = repository.save(user);
        timeLogger.logTime(methodName, Count.ONE.getCount());
        //repository.flush();
        return saved;
    }

    @Override
    public Collection<User> saveCollection(Collection<User> entities) {
        final String methodName = "SAVE";
        timeLogger.start();
        Collection<User> users = repository.save(entities);
        timeLogger.logTime(methodName, entities.size());
        //repository.flush();
        return users;
    }

    @Override
    public void updateName(User user, String name) {
        final String methodName = "UPDATE";
        timeLogger.start();
        repository.updateName(user.getId(), name);
        timeLogger.logTime(methodName, Count.ONE.getCount());
    }

}
