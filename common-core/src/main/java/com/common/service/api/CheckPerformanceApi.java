package com.common.service.api;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-04-03.
 */
public interface CheckPerformanceApi<T> {

    T saveOne();

    Collection<T> saveCollection();

    T update();

    T remove();

    T findById(Long id);


}
