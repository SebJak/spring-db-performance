package com.langpath.service.impl;

import com.langpath.Application;
import com.langpath.exceptions.FailLoginException;
import com.langpath.exceptions.FailLogoutException;
import com.langpath.sql.model.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

/**
 * Created by Sebastian on 2016-03-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test(expected = FailLoginException.class)
    public void testWrongCredentialLogin(){
        userService.login("login", "password");
    }

    @Test(expected = FailLoginException.class)
    public void testNullLogin() throws Exception {
        userService.login(null, null);
    }

    @Test(expected = FailLoginException.class)
    public void testNullNameLogin() throws Exception {
        userService.login(null, "pass");
    }

    @Test(expected = FailLoginException.class)
    public void testNullPassLogin() throws Exception {
        userService.login("login", null);
    }

    @Test
    public void testSecondLoginLogin() throws Exception {
        userService.login("login", "password");
        userService.login("login", "password");
        //Need add check action on second user;
    }

    @Test
    public void testLogout() throws Exception {
        Optional<User> user = userService.login("correctLogin", "correctPass");
        userService.logout(user.get());
    }

    @Test(expected = FailLogoutException.class)
    public void testLogoutNoLoggedUser() throws Exception {
        User user = new User();
        userService.logout(user);
    }

    @Test(expected = FailLogoutException.class)
    public void testLogoutNullUser() throws Exception {
        userService.logout(null);
    }

    @Test
    public void testSave() throws Exception {
        User user = new User();
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