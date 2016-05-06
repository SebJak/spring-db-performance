package com.langpath.mongo.service.util.impl;


import com.common.service.api.CheckPerformanceApi;
import com.common.service.api.CrudApi;
import com.common.service.api.EntityFactoryBuilder;
import com.langpath.mongo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by Sebastian on 2016-04-03.
 */
@Service("userMongoPerformance")
public class UserMongoPerformance implements CheckPerformanceApi<User> {

    @Autowired
    @Qualifier("userCrudService")
    private CrudApi<User, Long> userCrudService;

    @Qualifier("userFactoryBuilder")
    @Autowired
    private EntityFactoryBuilder userBuilder;


    @Override
    public User saveOne() {
        List<User> userList = new ArrayList<>(userBuilder.build(1));
        return userList.get(0);
    }

    @Override
    public Collection<User> saveCollection() {
        Collection<User> users = userBuilder.build(100);
        return users;
    }

    @Override
    public User update() {
        return update(100);
    }

    private User update(int times) {
        List<User> users = new ArrayList<>(userBuilder.build(1));
        for (int i = 0; i < times; i++)
            users.forEach(u -> userCrudService.update(u));
        return users.get(0);
    }

    @Override
    public User remove() {
        List<User> users = new ArrayList<>(userBuilder.build(1));
        users.forEach(u -> userCrudService.remove(u));
        return users.get(0);
    }


    @Override
    public User findById(Long id) {
        Optional<User> user = userCrudService.findById(id);
        return user.get();
    }
}
