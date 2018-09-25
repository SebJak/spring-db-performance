package com.langpath.data.repositories;

import com.langpath.data.model.entity.word.WordGroup;
import com.model_old.AggregationWordGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Sebastian on 2016-03-18.
 */
@Repository
@Transactional
public interface WordGroupRepository extends JpaRepository<WordGroup,Long> {

    @Query(value = "SELECT new com.model.AggregationWordGroup(wg.name, COUNT(*)) from WordGroup as wg, Word as w where wg = w.wordGroup group by wg.name")
    Collection<AggregationWordGroup> getAggregation();

    @Modifying
    @Query(value = "DELETE FROM WordGroup wg WHERE wg.id=?1")
    void deleteWordGroup(long id);
}
