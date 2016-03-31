package com.langpath.service.impl;

import com.langpath.data.model.entity.user.User;
import com.langpath.service.api.SecurityUserApi;

import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-31.
 */
public class SecurityUserService implements SecurityUserApi {

    @Override
    public Optional<User> login(String login, String password) {
        return null;
    }

    @Override
    public Boolean logout(User user) {
        return null;
    }
}
