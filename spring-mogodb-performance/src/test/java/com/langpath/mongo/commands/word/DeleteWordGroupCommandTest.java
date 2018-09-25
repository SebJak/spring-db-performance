package com.langpath.mongo.commands.word;

import com.langpath.mongo.MongoApplication;
import com.langpath.mongo.model.WordGroup;
import com.langpath.mongo.repository.WordGroupRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by root on 12.10.16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MongoApplication.class)
@ActiveProfiles(value = "test")
public class DeleteWordGroupCommandTest {

    @Autowired
    DeleteWordGroupCommand command;

    @Autowired
    WordGroupRepository repository;

    @Test
    public void removeWordGroup() throws Exception {
        Page<WordGroup> pages = repository.findAll(new PageRequest(1,200));
        pages.forEach(wordGroup -> {
            command.removeWordGroup(wordGroup.getId());

        });
        //{ _id: ObjectId("57fd104900b2abf9b9bde94c") }
        //> db.users.find({ wordGroups: { $in: ["57fd104900b2abf9b9bde94c"]} })

    }

}