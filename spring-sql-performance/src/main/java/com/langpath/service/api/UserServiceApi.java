package com.langpath.service.api;

import com.langpath.sql.model.entity.user.User;

import java.util.Optional;

/**
 * Created by sjakowski on 2016-03-16.
 */
public interface UserServiceApi extends CommonApi<User, Long>{

    Optional<User> login(String login, String password);

    Boolean logout(User user);
}
