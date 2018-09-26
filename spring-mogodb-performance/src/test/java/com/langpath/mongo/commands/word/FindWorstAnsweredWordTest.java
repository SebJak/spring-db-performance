package com.langpath.mongo.commands.word;

import com.langpath.mongo.model.User;
import com.langpath.mongo.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created by root on 14.10.16.
 */
public class FindWorstAnsweredWordTest extends AbstractTestMongo{

    @Autowired
    FindWorstAnsweredWord command;

    @Autowired
    UserRepository repository;

    @Test
    public void findWord() {
        int pageNumber = 1;
        int pagecontentNo = 100;
        Page<User> userPage = repository.findAll(new PageRequest(pageNumber,pagecontentNo));
        while(userPage.hasNext()) {
            workWithContent(userPage.getContent());
            userPage = repository.findAll(new PageRequest(++pageNumber, pagecontentNo));
        }
        workWithContent(userPage.getContent());
    }

    private void workWithContent(List<User> users) {
        users.forEach(user -> command.findWorstAnsweredGroup(user.getId()));
    }
}