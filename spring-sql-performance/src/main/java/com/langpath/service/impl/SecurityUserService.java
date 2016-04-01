package com.langpath.service.impl;

import com.langpath.data.model.entity.user.User;
import com.langpath.data.repositories.UserRepository;
import com.langpath.exceptions.FailLoginException;
import com.langpath.service.api.SecurityUserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-31.
 */
public class SecurityUserService implements SecurityUserApi {

    //http://stackoverflow.com/questions/10826293/restful-authentication-via-spring

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

    @Override
    public Boolean logout(User user) {
        return null;
    }

    private boolean checkPassword(String correctPass, String passedPassword) {
        //Todo add logic with coding password
        return correctPass.equals(passedPassword);
    }

}
