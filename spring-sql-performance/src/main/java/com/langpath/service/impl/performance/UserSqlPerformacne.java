package com.langpath.service.impl.performance;

import com.common.service.api.CrudApi;
import com.langpath.data.model.entity.user.User;
import com.common.service.api.CheckPerformanceApi;
import com.common.service.api.EntityFactoryBuilder;
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
@Service("userSqlPerformance")
public class UserSqlPerformacne  implements CheckPerformanceApi<User> {

    @Autowired
    @Qualifier("userCrudService")
    private CrudApi<User,Long> userService;

    @Qualifier("userBuilder")
    @Autowired
    private EntityFactoryBuilder userBuilder;


    @Override
    public User saveOne() {
        List<User> userList = new ArrayList<>(userBuilder.build(1));
        return userList.get(0);
    }

    @Override
    public Collection<User> saveCollection(){
       Collection<User> users = userBuilder.build(100);
        return users;
    }

    @Override
    public User update(){
        return update(100);
    }

    private User update(int times) {
        List<User> users = new ArrayList<>(userBuilder.build(1));
        for(int i=0;i<times;i++)
            users.forEach(u -> userService.update(u));
        return  users.get(0);
    }

    @Override
    public User remove() {
        List<User> users = new ArrayList<>(userBuilder.build(1));
        users.forEach(u -> userService.remove(u));
        return  users.get(0);
    }

    @Override
    public User findById(Long id) {
        return userService.findById(id).get();
    }

}
