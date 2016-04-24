package com.langpath.neo4j.service.impl;

import com.common.service.api.CrudApi;
import com.common.service.api.TimeLogger;
import com.langpath.neo4j.model.User;
import com.langpath.neo4j.repositories.UserRepository;
import com.langpath.neo4j.service.api.UserService;
import common.model.enums.Count;
import org.neo4j.helpers.collection.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

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
