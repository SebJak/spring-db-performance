package com.langpath.mongo.command;

import com.langpath.mongo.model.User;
import com.langpath.mongo.model.WordGroup;
import com.service.api.CrudApi;
import com.service.impl.CrudImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@ContextConfiguration
public class WordGroupInfoTest {

    @Autowired
    CrudApi<User, String> userCrud;

    WordGroupInfo wordGroupInfo;

    @Before
    public void setUp(){
        wordGroupInfo = new WordGroupInfo(userCrud);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotFindUser() throws Throwable {
        String userId = "NOT_EXISTS";
        Mockito.when(userCrud.findById(userId)).thenReturn(Optional.empty());

        wordGroupInfo.findWorstAnsweredWordGroup(userId);
    }

    @Test
    public void shouldNotFindGroupForUser() throws Throwable {
        String userId = "NOT_HAS_GROUP";
        Mockito.when(userCrud.findById(userId)).thenReturn(buildUser());
        WordGroup result = wordGroupInfo.findWorstAnsweredWordGroup(userId);

        assertEquals(null, result);
    }

    private Optional<User> buildUser() {
        return Optional.of(User.builder()
                .id("NOT_HAS_GROUP")
                .firstName("John")
                .lastName("Kowalsky")
                .build());
    }

    @Configuration
    static class Config {

        @Bean
        CrudApi<User, String> userStringCrudApi() {
            return Mockito.mock(CrudImpl.class);
        }
    }
}