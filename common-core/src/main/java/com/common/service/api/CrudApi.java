package com.common.service.api;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
public interface CrudApi<K,T extends Serializable> {

    Optional<K> save(K entity);

    Optional<Iterable<K>> save(Iterable<K> entities);

    Optional<K> update(K entity);

    Optional<K> findById(T id);

    Optional<Iterable<K>> findAll();

    Boolean remove(K entity);

    //Optional<Collection<K>> findByIds(Collection<Long> ids);
}
