package com.langpath.service.api;

import com.langpath.data.model.entity.user.User;

import java.util.Collection;

/**
 * Created by sjakowski on 2016-03-16.
 */
public interface UserServiceApi {

    User saveOne(User user);

    Collection<User> saveCollection(Collection<User> entites);

    void updateName(User user, String name);
}
