package com.langpath.service.impl;

import com.google.common.collect.Iterables;
import com.langpath.data.repositories.UserRepository;
import com.langpath.service.api.UserServiceApi;
import com.langpath.data.model.entity.user.User;
import com.common.service.api.TimeLogger;
import common.model.enums.Count;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by sjakowski on 2016-03-16.
 */
@Service
public class UserService implements UserServiceApi {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    @Qualifier("sqlTimeLogger")
    private TimeLogger timeLogger;


}
