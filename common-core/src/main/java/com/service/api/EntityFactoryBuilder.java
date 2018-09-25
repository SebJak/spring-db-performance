package com.service.api;

import java.util.Collection;

/**
 * Created by Sebastian on 2016-04-03.
 */
public interface EntityFactoryBuilder<T> {

    Collection<T> buildAndPersist(int count);

    Collection<T> build(int count);
}
