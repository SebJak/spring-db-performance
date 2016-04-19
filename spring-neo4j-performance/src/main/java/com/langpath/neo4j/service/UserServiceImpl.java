package com.langpath.neo4j.service;

import com.common.service.api.CrudApi;
import com.common.service.api.TimeLogger;
import com.langpath.neo4j.model.User;
import com.langpath.neo4j.repositories.UserRepository;
import common.model.enums.Count;
import org.neo4j.helpers.collection.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-04-12.
 */
@Service
public class UserServiceImpl implements CrudApi<User, Long> {

    @Autowired
    private UserRepository repository;

    @Autowired
    @Qualifier("neo4jTimeLogger")
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
        Optional<Collection<User>> saved = Optional.ofNullable(Iterables.toList(repository.save(users))); //TODO test if return is empty
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
    public Optional<Collection<User>> findAll() { //FIXME
        final String methodName = "SELECT_ALL";
        timeLogger.start();
//        Optional<Collection<User>> found = Optional.ofNullable(repository.findAll());
//        if(found.isPresent()) {
//            timeLogger.logTime(methodName, found.get().size());
//        }
        return null;
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
    public Optional<Collection<User>> findByIds(Collection<Long> ids) { //FIXME
        final String methodName = "SELECT_IDS";
        timeLogger.start();
//        Collection<User> users = repository.findByIdIn(ids);
        timeLogger.logTime(methodName, ids.size());
        return null;
    }
}
