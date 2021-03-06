package com.langpath.service.impl;

import com.model_old.AggregationWordGroup;
import com.langpath.data.repositories.WordGroupRepository;

import com.langpath.service.api.WordGroupServiceApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Sebastian on 2016-03-18.
 */
@Service
public class WordGroupService implements WordGroupServiceApi{

    private static final Logger logger = LoggerFactory.getLogger(WordGroupService.class);

    @Autowired
    private WordGroupRepository repository;


    @Override
    public Collection<AggregationWordGroup> getAggregationWordGroup() {
        Collection<AggregationWordGroup> results = repository.getAggregation();
        return results;
    }
}
