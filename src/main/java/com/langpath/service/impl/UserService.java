package com.langpath.service.impl;

import com.langpath.service.api.UserServiceApi;
import com.langpath.sql.model.entity.user.User;

import java.util.Collection;

/**
 * Created by sjakowski on 2016-03-16.
 */
public class UserService implements UserServiceApi {


    @Override
    public User login(String login, String password) {
        return null;
    }

    @Override
    public Boolean logout(User user) {
        return null;
    }

    @Override
    public User save(User word) {
        return null;
    }

    @Override
    public User update(User word) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public Collection<User> findAll() {
        return null;
    }

    @Override
    public Boolean remove(User word) {
        return null;
    }
}
