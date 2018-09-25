package com.langpath.service.impl.performance;

import com.service.api.CrudApi;
import com.langpath.data.model.entity.user.User;
import com.service.api.EntityFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Created by Sebastian on 2016-04-03.
 */
@Service("userSqlPerformance")
public class UserSqlPerformacne  implements CheckPerformanceApi<User> {

    @Autowired
    @Qualifier("userCrudService")
    private CrudApi<User,Long> userService;


    @Autowired
    @Qualifier("userFactoryBuilder")
    private EntityFactoryBuilder userBuilder;


    @Override
    public User saveOne() {
        List<User> userList = new ArrayList<>(userBuilder.buildAndPersist(1));
        return userList.get(0);
    }

    @Override
    public Collection<User> saveCollection(){
       Collection<User> users = userBuilder.buildAndPersist(100);
        return users;
    }

    @Override
    public User updateOne(){
        return userService.update(update(1).stream().findFirst().get()).get(); //FIXME szachu machu :)
    }

    @Override
    public Iterable<User> updateCollection() {
        return userService.update(update(100)).get();
    }

    private Collection<User> update(int times) {
        List<User> users = new ArrayList<>(userBuilder.buildAndPersist(times));
        users.forEach(u -> u.setLastName(UUID.randomUUID().toString()));
        return  users;
    }

    @Override
    public User remove() {
        List<User> users = new ArrayList<>(userBuilder.buildAndPersist(100));
        users.forEach(u -> userService.remove(u));
        return  users.get(0);
    }

    @Override
    public User findById(Long id) {
        return userService.findById(id).get();
    }


}
