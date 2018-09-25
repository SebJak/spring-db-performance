package com.langpath.service.impl;

import static org.junit.Assert.*;

import com.langpath.data.model.entity.base.BaseEntity;
import com.service.api.CrudApi;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * Created by sjakowski on 2016-03-30.
 */
public abstract class GenericCrudTests<T extends BaseEntity, E extends CrudApi> {

    @Autowired
    private E service;

    abstract T getCorrectObjectToSave();

    @Test
    public void testSave() throws Exception {
        T entity = getCorrectObjectToSave();
        Optional<T> saved = service.save(entity);
        assertEquals("Should be present", saved.isPresent());
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testFindById() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {

    }
}
