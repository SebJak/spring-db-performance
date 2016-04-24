package com.langpath.service.impl;

import com.langpath.data.model.entity.word.WordGroup;
import common.model.AggregationWordGroup;
import com.langpath.data.repositories.WordGroupRepository;

import com.langpath.service.api.WordGroupServiceApi;

import com.common.service.api.TimeLogger;
import common.model.enums.Count;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
@Service
public class WordGroupService implements WordGroupServiceApi{

    private static final Logger logger = LoggerFactory.getLogger(WordGroupService.class);

    @Autowired
    private WordGroupRepository repository;

    @Autowired
    @Qualifier("sqlTimeLogger")
    private TimeLogger timeLogger;

    @Override
    public Collection<AggregationWordGroup> getAggregationWordGroup() {
        final String method = "AGGREGATION_1";
        timeLogger.start();
        Collection<AggregationWordGroup> results = repository.getAggregation();
        timeLogger.logTime(method,results.size());
        return results;
    }
}
