package com.langpath.service.impl;

import static org.junit.Assert.*;

import com.common.service.api.CrudApi;
import com.langpath.Application;
import com.langpath.data.model.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Sebastian on 2016-03-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@ActiveProfiles(value = "test")
public class UserServiceTest {

    @Autowired
    private CrudApi<User,Long> userService;

    @Test
    public void testSave() throws Exception {
        User user = buildUser();
        Optional<User> saved = userService.save(user);
        assertEquals("Saved should be present", true, saved.isPresent());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testFailWithDoubleLoginSave() throws Exception {
        User user = buildUser();
        User user2 = buildUser();
        user2.setLogin(user.getLogin());
        Optional<User> savedTrue = userService.save(user);
        assertEquals("Saved should be present", true, savedTrue.isPresent());
        userService.save(user2);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testFailWithNullLoginSave() throws Exception {
        User user = buildUser();
        user.setLogin(null);
        userService.save(user);
    }

    @Test
    public void testUpdate() throws Exception {
        User user = buildUser();
        String updateValue = "Marian";
        Optional<User> saved = userService.save(user);
        assertEquals("Saved should be present", true, saved.isPresent());

        user = saved.get();
        user.setLastName(updateValue);
        saved = userService.update(user);
        assertEquals("Should change value", updateValue, saved.get().getLastName());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void testFailUpdateWithDoubleLogin() throws Exception {
        User user = buildUser();
        User user2 = buildUser();
        Optional<User> saved = userService.save(user);
        userService.save(user2);
        assertEquals("Saved should be present", true, saved.isPresent());

        user = saved.get();
        user.setLogin(user2.getLogin());
        userService.update(user);
    }

    @Test
    public void testFindById() throws Exception {
        User user = buildUser();
        Optional<User> saved = userService.save(user);
        assertEquals("Saved should be present", true, saved.isPresent());
        Optional<User> findById = userService.findById(saved.get().getId());
        assertEquals("Saved should be present", true, findById.isPresent());
    }

    @Test
    public void testFindAll() throws Exception {
        User user = buildUser();
        Optional<User> saved = userService.save(user);
        assertEquals("Saved should be present", true, saved.isPresent());
        assertEquals("Should find some data", true, userService.findAll().isPresent());
    }

    //@Test
    public void testRemove() throws Exception {

    }

    private User buildUser() {
        Date data = new Date();
        User user = new User();
        user.setFirstName("First Name " + data);
        user.setLastName("Last name" + data);
        user.setLogin("login_"+ UUID.randomUUID());
        user.setPassword(data.toString());
        return user;
    }
}