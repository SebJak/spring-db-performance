package com.langpath.service.impl;

import com.langpath.Application;
import com.langpath.data.model.entity.user.User;
import com.langpath.data.model.entity.word.Word;
import com.service.api.CrudApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by Sebastian on 2016-04-23.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@ActiveProfiles(value = "test")
public class CrudServicesTest {

    @Autowired
    @Qualifier("userCrudService")
    CrudApi<User, Long> crudUser;

    @Autowired
    @Qualifier("wordCrudService")
    CrudApi<Word, Long> wordCrudService;

    @Test
    public void initCrudUserTest() {
        assertTrue("Should be present", crudUser.findAll().isPresent());
    }

    @Test
    public void initCrudWordTest() {
        assertTrue("Should be present", wordCrudService.findAll().isPresent());
    }
}
