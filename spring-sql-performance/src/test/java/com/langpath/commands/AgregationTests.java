package com.langpath.commands;

import com.langpath.data.model.entity.user.User;
import com.langpath.data.repositories.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created by root on 13.10.16.
 */
public class AgregationTests {

    @Autowired
    GetWorstAnsweredWord worstAnsweredWord;

    @Autowired
    UserRepository userRepository;

    @Test
    public void findTheWorstWordForUser() {
        Page<User> usersPage = userRepository.findAll(new PageRequest(1,200));
        for(int i=0; i<usersPage.getTotalPages();i++) {
            List<User> users = usersPage.getContent();
            users.forEach(user -> {
                System.out.println(user.getId());
                worstAnsweredWord.getWorstWordForUser(user.getId());
            });
        }
    }
}
