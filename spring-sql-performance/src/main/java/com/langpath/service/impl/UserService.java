package com.langpath.service.impl;

import com.langpath.data.repositories.UserRepository;
import com.langpath.service.api.UserServiceApi;
import com.langpath.data.model.entity.user.User;
import com.common.service.api.TimeLogger;
import common.model.enums.Count;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

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
    public Optional<User> save(User user) {
        final String methodName = "SAVE";
        timeLogger.start();
        Optional<User> saved = Optional.ofNullable(repository.save(user));
        if(saved.isPresent()) {
            timeLogger.logTime(methodName, Count.ONE.getCount());
        }
        return saved;
    }

    @Override
    public Optional<Collection<User>> save(Iterable<User> users) {
        final String methodName = "SAVE";
        timeLogger.start();
        Optional<Collection<User>> saved = Optional.ofNullable(repository.save(users));
        if(saved.isPresent()) {
            timeLogger.logTime(methodName, saved.get().size());
        }
        return saved;
    }

    @Override
    public Optional<User> update(User user) {
        final String methodName = "UPDATE";
        timeLogger.start();
        Optional<User> update = Optional.ofNullable(repository.save(user));
        if(update.isPresent()) {
            timeLogger.logTime(methodName, Count.ONE.getCount());
        }
        return update;
    }

    @Override
    public Optional<User> findById(Long id) {
        final String methodName = "SELECT_BY_ID";
        timeLogger.start();
        Optional<User> found = Optional.ofNullable(repository.findOne(id));
        if(found.isPresent()) {
            timeLogger.logTime(methodName, Count.ONE.getCount());
        }
        return found;
    }

    @Override
    public Optional<Collection<User>> findAll() {
        final String methodName = "SELECT_ALL";
        timeLogger.start();
        Optional<Collection<User>> found = Optional.ofNullable(repository.findAll());
        if(found.isPresent()) {
            timeLogger.logTime(methodName, found.get().size());
        }
        return found;
    }

    @Override
    public Boolean remove(User user) {
        final String methodName = "DELETE";
        timeLogger.start();
        repository.delete(user);
        timeLogger.logTime(methodName, Count.ONE.getCount());
        return Boolean.TRUE;
    }

    @Override
    public Optional<Collection<User>> findByIds(Collection<Long> ids) {
        final String methodName = "SELECT_IDS";
        timeLogger.start();
        Collection<User> users = repository.findByIdIn(ids);
        timeLogger.logTime(methodName, ids.size());
        return Optional.of(users);
    }

}
