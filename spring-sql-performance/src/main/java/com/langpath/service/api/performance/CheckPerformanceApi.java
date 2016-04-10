package com.langpath.service.api.performance;

import com.langpath.data.model.entity.base.BaseEntity;
import com.langpath.data.model.entity.user.User;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-04-03.
 */
public interface CheckPerformanceApi<T extends BaseEntity> {

    T saveOne();

    Collection<T> saveCollection();

    T update();

    T remove();

    T findById();

    Optional<Collection<T>> findByIds();


}
