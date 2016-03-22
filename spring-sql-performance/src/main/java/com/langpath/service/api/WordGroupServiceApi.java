package com.langpath.service.api;

import com.langpath.sql.model.entity.word.WordGroup;
import com.langpath.sql.model.helps.WordGroupAggregation;

/**
 * Created by Sebastian on 2016-03-18.
 */
public interface WordGroupServiceApi extends CommonApi<WordGroup, Long>{

    WordGroupAggregation getAggregationWordGroup();

}
