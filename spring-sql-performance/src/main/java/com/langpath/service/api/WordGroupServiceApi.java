package com.langpath.service.api;

import com.common.service.api.CrudApi;
import com.langpath.data.model.entity.word.WordGroup;
import common.model.AggregationWordGroup;

import java.util.Collection;

/**
 * Created by Sebastian on 2016-03-18.
 */
public interface WordGroupServiceApi {

    Collection<AggregationWordGroup> getAggregationWordGroup();

}
