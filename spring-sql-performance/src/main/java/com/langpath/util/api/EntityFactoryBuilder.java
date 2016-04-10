package com.langpath.util.api;

import com.langpath.data.model.entity.base.BaseEntity;
import com.langpath.data.model.entity.word.Word;

import java.util.Collection;

/**
 * Created by Sebastian on 2016-04-03.
 */
public interface EntityFactoryBuilder<T extends BaseEntity> {

    Collection<T> build(int count);
}
