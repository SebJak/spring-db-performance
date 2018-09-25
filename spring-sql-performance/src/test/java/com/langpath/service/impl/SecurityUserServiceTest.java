package com.langpath.service.impl;

import com.langpath.Application;
import com.langpath.data.model.entity.user.User;
import com.langpath.exceptions.FailLoginException;
import com.langpath.exceptions.FailLogoutException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by sjakowski on 2016-04-01.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@ActiveProfiles(value = "test")
public class SecurityUserServiceTest {

    @Autowired
    private SecurityUserService service;

    @Test(expected = FailLoginException.class)
    public void testWrongCredentialLogin() throws Exception{
        service.login("login", "password");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullLogin() throws Exception {
        service.login(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullNameLogin() throws Exception {
        service.login(null, "pass");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPassLogin() throws Exception {
        service.login("login", null);
    }

    @Test(expected = FailLogoutException.class)
    public void testSecondLoginLogin() throws Exception {
        //todo Prepare data before login to system.
        service.login("login", "password");
        service.login("login", "password");
        //Need add check action on second user;
    }

    @Test
    public void testLogout() throws FailLoginException {
        //todo Prepare data before login to system.
        User user = service.login("correctLogin", "correctPass");
        service.logout(user);
    }

    @Test(expected = FailLogoutException.class)
    public void testLogoutNoLoggedUser() throws Exception {
        User user = new User();
        service.logout(user);
    }

    @Test(expected = FailLogoutException.class)
    public void testLogoutNullUser() throws Exception {
        service.logout(null);
    }

}