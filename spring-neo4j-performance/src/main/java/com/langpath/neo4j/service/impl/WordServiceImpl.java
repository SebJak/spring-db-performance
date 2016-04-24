package com.langpath.neo4j.service.impl;

import com.common.service.api.CrudApi;
import com.common.service.api.TimeLogger;
import com.langpath.neo4j.model.Word;
import com.langpath.neo4j.repositories.WordRepository;
import com.langpath.neo4j.service.api.WordGroupService;
import com.langpath.neo4j.service.api.WordService;
import common.model.enums.Count;
import org.neo4j.helpers.collection.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-04-12.
 */
@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordRepository repository;

    @Autowired
    @Qualifier("neo4jTimeLogger")
    private TimeLogger timeLogger;



}
