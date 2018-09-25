package com.langpath.neo4j.commands;

import com.langpath.neo4j.AbstractTestClass;
import com.langpath.neo4j.model.WordGroup;
import com.langpath.neo4j.repositories.WordGroupRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.junit.Assert.*;

/**
 * Created by root on 12.10.16.
 */

public class DeleteWordGroupTest extends AbstractTestClass{

    @Autowired
    DeleteWordGroup command;

    @Autowired
    WordGroupRepository repository;

    @Test
    public void deleteWordGroup() throws Exception {
        Page<WordGroup> wordGroupPage= repository.findAll(new PageRequest(1,100));
        wordGroupPage.forEach(wordGroup -> {
            command.deleteWordGroup(wordGroup.getId());
        });
    }

}