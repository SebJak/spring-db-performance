package com.langpath.neo4j.commands;

import com.langpath.neo4j.AbstractTestClass;
import com.langpath.neo4j.model.User;
import com.langpath.neo4j.repositories.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by root on 14.10.16.
 */
public class FindWorstAnsweredWordTest extends AbstractTestClass {
    @Autowired
    FindWorstAnsweredWord command;

    @Autowired
    UserRepository userRepository;


    @Test
    public void getWorstAnsweredWord() throws Exception {
        int pageNumber = 1;
        int pageContentNo = 100;
        Page<User> userPage = userRepository.findAll(new PageRequest(pageNumber, pageContentNo));
        while (userPage.hasNext()) {
            processPageContent(userPage);
            userPage = userRepository.findAll(new PageRequest(++pageNumber, pageContentNo));
        }
        processPageContent(userPage);
    }


    private void processPageContent(Page<User> userPage) {
        List<User> users = userPage.getContent();
        users.forEach(user -> command.getWorstAnsweredWord(user.getId()));
    }

}