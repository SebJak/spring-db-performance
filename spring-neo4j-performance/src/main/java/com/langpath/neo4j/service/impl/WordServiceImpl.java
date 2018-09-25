package com.langpath.neo4j.service.impl;

import com.langpath.neo4j.repositories.WordRepository;
import com.langpath.neo4j.service.api.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Sebastian on 2016-04-12.
 */
@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordRepository repository;

//    @Autowired
//    @Qualifier("neo4jTimeLogger")
//    private TimeLogger timeLogger;



}
