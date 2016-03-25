package com.langpath.service.api;

import com.langpath.data.model.entity.word.WordGroup;

import java.util.Collection;

/**
 * Created by Sebastian on 2016-03-18.
 */
public interface WordGroupServiceApi extends CommonApi<WordGroup, Long>{

    Collection<AggregationWordGroup> getAggregationWordGroup();

}
