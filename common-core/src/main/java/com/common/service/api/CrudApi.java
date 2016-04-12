package com.common.service.api;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
public interface CrudApi<K,T> {

    Optional<K> save(K entity);

    Optional<Collection<K>> save(Iterable<K> entities);

    Optional<K> update(K entity);

    Optional<K> findById(T id);

    Optional<Collection<K>> findAll();

    Boolean remove(K entity);

    Optional<Collection<K>> findByIds(Collection<Long> ids);
}
