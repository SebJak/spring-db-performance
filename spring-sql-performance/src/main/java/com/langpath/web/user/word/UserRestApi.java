package com.langpath.web.user.word;

import com.service.api.CrudApi;
import com.langpath.data.model.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sebastian on 2016-07-18.
 */
@RestController("/user")
public class UserRestApi {

    @Autowired
    @Qualifier("userCrudService")
    CrudApi<User, Long> crudUser;

    @RequestMapping(method = RequestMethod.GET, path = "/getUser")
    public void getUser(@RequestBody Object user){

    }
}
