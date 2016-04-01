package com.langpath.service.api;

import com.langpath.data.model.entity.user.User;

import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-31.
 */
public interface SecurityUserApi {

    Optional<User> login(String login, String password);

    Boolean logout(User user);
}
