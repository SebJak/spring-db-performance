package com.langpath.neo4j.service;

import com.common.service.api.CrudApi;
import com.langpath.neo4j.model.User;
import com.langpath.neo4j.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-04-12.
 */
@Service
public class UserServiceImpl implements CrudApi<User, Long> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> save(User entity) {
        return null;
    }

    @Override
    public Optional<Collection<User>> save(Iterable<User> entities) {
        return null;
    }

    @Override
    public Optional<User> update(User entity) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return null;
    }

    @Override
    public Optional<Collection<User>> findAll() {
        return null;
    }

    @Override
    public Boolean remove(User entity) {
        return null;
    }

    @Override
    public Optional<Collection<User>> findByIds(Collection<Long> ids) {
        return null;
    }
}
