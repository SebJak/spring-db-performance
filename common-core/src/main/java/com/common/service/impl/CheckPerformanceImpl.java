package com.common.service.impl;


import com.common.service.api.CheckPerformanceApi;
import com.common.service.api.CrudApi;
import com.common.service.api.EntityFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Sebastian on 2016-04-03.
 */
public class CheckPerformanceImpl<T> implements CheckPerformanceApi {

    private CrudApi<T, Long> crudService;

    private EntityFactoryBuilder factoryBuilder;

    @Autowired
    public CheckPerformanceImpl(CrudApi<T, Long> crudService, EntityFactoryBuilder factoryBuilder) {
        this.crudService = crudService;
        this.factoryBuilder = factoryBuilder;
    }


    @Override
    public T saveOne() {
        List<T> userList = new ArrayList<>(factoryBuilder.build(1));
        return userList.get(0);
    }

    @Override
    public Collection<T> saveCollection() {
        Collection<T> users = factoryBuilder.build(100);
        return users;
    }

    @Override
    public T update() {
        return update(100);
    }

    private T update(int times) {
        List<T> users = new ArrayList<>(factoryBuilder.build(1));
        for (int i = 0; i < times; i++)
            users.forEach(u -> crudService.update(u));
        return users.get(0);
    }

    @Override
    public T remove() {
        List<T> users = new ArrayList<>(factoryBuilder.build(1));
        users.forEach(u -> crudService.remove(u));
        return users.get(0);
    }

    @Override
    public T findById(Long id) {
        List<T> users = new ArrayList<>(factoryBuilder.build(100));
        users.forEach(u -> crudService.findById(id));
        return users.get(0);
    }

}
