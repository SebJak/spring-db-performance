package com.langpath.service.api;

import com.langpath.data.model.entity.word.WordGroup;
import com.langpath.data.model.helps.WordGroupAggregation;

/**
 * Created by Sebastian on 2016-03-18.
 */
public interface WordGroupServiceApi extends CommonApi<WordGroup, Long>{

    WordGroupAggregation getAggregationWordGroup();

}
