package com.langpath.neo4j.service.impl.util;


import com.service.api.CrudApi;
import com.service.api.EntityFactoryBuilder;
import com.langpath.neo4j.model.User;
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
@Service("userNeo4jPerformance")
//@Transactional
public class UserNeo4jPerformance implements CheckPerformanceApi<User> {

    @Autowired
    @Qualifier("userCrudService")
    private CrudApi<User, Long> userCrudService;

    @Qualifier("userFactoryBuilder")
    @Autowired
    private EntityFactoryBuilder userBuilder;


    @Override
    public User saveOne() {
        List<User> userList = new ArrayList<>(userBuilder.buildAndPersist(1));
        return userList.get(0);
    }

    @Override
    public Collection<User> saveCollection() {
        Collection<User> users = userBuilder.buildAndPersist(100);
        return users;
    }

    @Override
    public User updateOne() {
        return update(100);
    }

    @Override
    public Iterable<User> updateCollection() {
        return null;
    }

    private User update(int times) {
        List<User> users = new ArrayList<>(userBuilder.buildAndPersist(times));
        for (int i = 0; i < times; i++)
            users.forEach(u -> userCrudService.update(u));
        return users.get(0);
    }

    @Override
    public User remove() {
        List<User> users = new ArrayList<>(userBuilder.buildAndPersist(1));
        users.forEach(u -> userCrudService.remove(u));
        return users.get(0);
    }


    @Override
    public User findById(Long id) {
        Optional<User> user = userCrudService.findById(id);
        return user.get();
    }
}
