package com.langpath.neo4j.service.impl;

import com.langpath.neo4j.repositories.UserRepository;
import com.langpath.neo4j.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Sebastian on 2016-04-12.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    @Qualifier("neo4jTimeLogger")
    private TimeLogger timeLogger;


}
