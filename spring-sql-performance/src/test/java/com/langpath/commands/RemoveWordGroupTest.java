package com.langpath.commands;

import com.langpath.Application;
import com.langpath.data.model.entity.word.WordGroup;
import com.langpath.data.repositories.WordGroupRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by root on 12.10.16.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@ActiveProfiles(value = "test")
public class RemoveWordGroupTest {

    @Autowired
    private RemoveWordGroup command;

    @Autowired
    private WordGroupRepository repository;

    @Test
    public void removeWordGroup() throws Exception {
        Page<WordGroup> wordGroupPage= repository.findAll(new PageRequest(1,10));
        wordGroupPage.forEach(wordGroup -> {
            command.removeWordGroup(wordGroup.getId());
        }

        );
    }

}