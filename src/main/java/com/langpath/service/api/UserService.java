package com.langpath.service.api;

import com.langpath.sql.model.entity.User;

/**
 * Created by sjakowski on 2016-03-16.
 */
public class UserService implements UserServiceApi {

    @Override
    public void save(User user) {
        String castException = (String) user;
    }
}
