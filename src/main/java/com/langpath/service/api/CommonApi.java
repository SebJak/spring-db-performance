package com.langpath.service.api;

import java.util.Collection;

/**
 * Created by Sebastian on 2016-03-18.
 */
public interface CommonApi<K,T> {
    K save(K word);

    K update(K word);

    K findById(T id);

    Collection<K> findAll();

    Boolean remove(K word);

}
