package com.langpath.neo4j.service.impl;

import com.common.service.api.CrudApi;
import com.common.service.api.TimeLogger;
import com.google.common.collect.Iterables;
import com.langpath.neo4j.model.WordGroup;
import com.langpath.neo4j.repositories.WordGroupRepository;
import com.langpath.neo4j.service.api.WordGroupService;
import common.model.enums.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

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
