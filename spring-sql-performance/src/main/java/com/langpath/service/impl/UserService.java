package com.langpath.service.impl;

import com.langpath.data.repositories.UserRepository;
import com.langpath.exceptions.FailLoginException;
import com.langpath.service.api.UserServiceApi;
import com.langpath.data.model.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by sjakowski on 2016-03-16.
 */
@Service
public class UserService implements UserServiceApi {

    @Autowired
    private UserRepository repository;

    @Override
    public User login(String login, String password) throws FailLoginException {
        Assert.hasLength(login, "Login could not be empty");
        Assert.hasLength(password, "Password could not be empty");
        Optional<User> optionalUser = Optional.of(repository.findByLogin(login));
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            if(checkPassword(user.getPassword(),password)) {
                return user;
            }
        }
        throw new FailLoginException();
    }

    private boolean checkPassword(String correctPass, String passedPassword) {
        //Todo add logic with coding password
        return correctPass.equals(passedPassword);
    }

    @Override
    public Boolean logout(User user) {
        return null;
    }

    @Override
    public Optional<User> save(User word) {
        return null;
    }

    @Override
    public Optional<Collection<User>> save(Iterable<User> word) {
        return null;
    }

    @Override
    public Optional<User> update(User word) {
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
    public Boolean remove(User word) {
        return null;
    }

}
