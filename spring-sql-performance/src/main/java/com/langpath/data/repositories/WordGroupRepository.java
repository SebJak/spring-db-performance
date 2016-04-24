package com.langpath.data.repositories;

import com.langpath.data.model.entity.word.WordGroup;
import common.model.AggregationWordGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Sebastian on 2016-03-18.
 */
@Repository
public interface WordGroupRepository extends JpaRepository<WordGroup,Long> {

    @Query(value = "SELECT new common.model.AggregationWordGroup(wg.name, COUNT(*)) from WordGroup as wg, Word as w where wg = w.wordGroup group by wg.name")
    Collection<AggregationWordGroup> getAggregation();
}
