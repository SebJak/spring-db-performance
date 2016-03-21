package com.langpath.service.api;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
public interface CommonApi<K,T> {
    Optional<K> save(K word);

    Optional<K> update(K word);

    Optional<K> findById(T id);

    Optional<Collection<K>> findAll();

    Boolean remove(K word);

}
