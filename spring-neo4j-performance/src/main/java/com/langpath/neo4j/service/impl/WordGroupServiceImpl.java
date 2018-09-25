package com.langpath.neo4j.service.impl;

import com.langpath.neo4j.repositories.WordGroupRepository;
import com.langpath.neo4j.service.api.WordGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Sebastian on 2016-04-12.
 */
@Service("wordGroupService")
public class WordGroupServiceImpl implements WordGroupService {

    @Autowired
    private WordGroupRepository repository;

    @Autowired
    @Qualifier("neo4jTimeLogger")
    private TimeLogger timeLogger;


}
