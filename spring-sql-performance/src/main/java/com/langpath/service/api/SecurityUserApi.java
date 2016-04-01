package com.langpath.service.api;

import com.langpath.data.model.entity.user.User;
import com.langpath.exceptions.FailLoginException;

/**
 * Created by Sebastian on 2016-03-31.
 */
public interface SecurityUserApi {

    User login(String login, String password) throws FailLoginException;

    Boolean logout(User user);
}
