package com.langpath.service.api;

import com.langpath.data.model.entity.user.User;
import com.langpath.exceptions.FailLoginException;

/**
 * Created by sjakowski on 2016-03-16.
 */
public interface UserServiceApi extends CommonApi<User, Long>{

    User login(String login, String password) throws FailLoginException;

    Boolean logout(User user);
}
