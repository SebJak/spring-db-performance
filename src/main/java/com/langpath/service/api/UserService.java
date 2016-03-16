package com.langpath.service.api;

import com.langpath.sql.model.entity.User;

/**
 * Created by sjakowski on 2016-03-16.
 */
public class UserService implements UserServiceApi {

    @Override
    public void save(User user) {
        long value1 = 2l;
        int value2 = 2;

        if(value1==value2) {
            System.out.println("It works :)");
        }
    }
}
