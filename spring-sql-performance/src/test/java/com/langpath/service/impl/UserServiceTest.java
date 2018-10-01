package com.langpath.service.impl;

import com.langpath.Application;
import com.langpath.data.model.entity.user.User;
import com.langpath.service.api.UserServiceApi;
import com.service.api.EntityFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Sebastian on 2016-03-18.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@ActiveProfiles(value = "test")
public class UserServiceTest {

//    @Autowired
//    @Qualifier("userCrudService")
//    CrudApi<User, Long> userService;

    @Autowired
    private UserServiceApi userService;


    @Autowired
    @Qualifier("userFactoryBuilder")
    private EntityFactoryBuilder userBuilder;

    @Test
    public void testSave() throws Exception {
        List<User> user = new ArrayList<>(userBuilder.build(1));
        System.out.println(user);
        user.forEach(u -> {
            User saved = userService.saveOne(u);
            assertNotNull("Saved should be present", saved);
        });
    }

    @Test
    public void testSaveCollection() throws Exception {
        for(int i=0; i<100; i++) {
            List<User> user = new ArrayList<>(userBuilder.build(100));
            List<User> saved = new ArrayList<>(userService.saveCollection(user));
            assertNotNull("Saved should be present", saved);
        }
    }

    @Test
    public void testSaveFive() throws Exception {
        for(int i=0; i<2500; i++) {
            List<User> user = new ArrayList<>(userBuilder.build(5));
            List<User> saved = new ArrayList<>(userService.saveCollection(user));
            assertNotNull("Saved should be present", saved);
        }
    }

    @Test
    public void testUpdateName() throws Exception {
        List<User> user = new ArrayList<>(userBuilder.build(1));
        System.out.println(user);
        user.forEach(u -> {
            User saved = userService.saveOne(u);
            assertNotNull("Saved should be present", saved);
            System.out.println("Update");
            userService.updateName(saved, "UpdatetName");
        });

    }



//    @Test(expected = DataIntegrityViolationException.class)
//    public void testFailWithDoubleLoginSave() throws Exception {
//        User user = buildUser();
//        User user2 = buildUser();
//        user2.setLogin(user.getLogin());
//        Optional<User> savedTrue = userService.save(user);
//        assertEquals("Saved should be present", true, savedTrue.isPresent());
//        userService.save(user2);
//    }
//
//    @Test(expected = DataIntegrityViolationException.class)
//    public void testFailWithNullLoginSave() throws Exception {
//        User user = buildUser();
//        user.setLogin(null);
//        userService.save(user);
//    }
//
//    @Test
//    public void testUpdate() throws Exception {
//        User user = buildUser();
//        String updateValue = "Marian";
//        Optional<User> saved = userService.save(user);
//        assertEquals("Saved should be present", true, saved.isPresent());
//
//        user = saved.get();
//        user.setLastName(updateValue);
//        saved = userService.updateOne(user);
//        assertEquals("Should change value", updateValue, saved.get().getLastName());
//    }
//
//    @Test(expected = DataIntegrityViolationException.class)
//    public void testFailUpdateWithDoubleLogin() throws Exception {
//        User user = buildUser();
//        User user2 = buildUser();
//        Optional<User> saved = userService.save(user);
//        userService.save(user2);
//        assertEquals("Saved should be present", true, saved.isPresent());
//
//        user = saved.get();
//        user.setLogin(user2.getLogin());
//        userService.updateOne(user);
//    }
//
//    @Test
//    public void testFindById() throws Exception {
//        User user = buildUser();
//        Optional<User> saved = userService.save(user);
//        assertEquals("Saved should be present", true, saved.isPresent());
//        Optional<User> findById = userService.findById(saved.get().getId());
//        assertEquals("Saved should be present", true, findById.isPresent());
//    }
//
//    @Test
//    public void testFindAll() throws Exception {
//        User user = buildUser();
//        Optional<User> saved = userService.save(user);
//        assertEquals("Saved should be present", true, saved.isPresent());
//        assertEquals("Should find some data", true, userService.findAll().isPresent());
//    }
//
//    //@Test
//    public void testRemove() throws Exception {
//
//    }
//
//    private User buildUser() {
//        Date data = new Date();
//        User user = new User();
//        user.setFirstName("First Name " + data);
//        user.setLastName("Last name" + data);
//        user.setLogin("login_"+ UUID.randomUUID());
//        user.setPassword(data.toString());
//        user.setEmail(UUID.randomUUID() + "@abc.com");
//        return user;
//    }
}