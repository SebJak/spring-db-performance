package com.langpath.mongo.commands.word;

import com.langpath.mongo.MongoApplication;
import com.langpath.mongo.model.WordGroup;
import com.langpath.mongo.repository.UserRepository;
import com.langpath.mongo.repository.WordGroupRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by root on 12.10.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoApplication.class)
@ActiveProfiles(value = "test")
public class DeleteWordGroupCommandTest {

    @Autowired
    DeleteWordGroupCommand command;


    @Test
    public void removeWordGroup() throws Exception {
        String userId = "testId";
        String wordGroupId = "wordGroup";
        command.removeWordGroup(userId, wordGroupId);
    }

    @Configuration
    class TestConfiguration {

        @Bean
        UserRepository userRepository() {
            return Mockito.mock(UserRepository.class);
        }
    }

}