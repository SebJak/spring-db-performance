package com.langpath.commands;

import com.langpath.data.model.entity.user.User;
import com.langpath.data.model.entity.word.WordGroup;
import com.langpath.data.repositories.UserRepository;
import com.langpath.data.repositories.WordGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Created by root on 13.10.16.
 */
@Service
class SetGroupOwner {

    private WordGroupRepository wgRepository;

    private UserRepository userRepository;

    public SetGroupOwner(WordGroupRepository wgRepository, UserRepository userRepository) {
        this.wgRepository = wgRepository;
        this.userRepository = userRepository;
    }

    void setWordGroupOwnerForEachGroup() {
        Iterable<WordGroup> wordGroups = wgRepository.findAll();
        List<User> users = userRepository.findAll();
        Random rm = new Random();
        int length = users.size();
        wordGroups.forEach(wordGroup -> {
            wordGroup.setOwner(users.get(rm.nextInt(length)));
        });
        wgRepository.save(wordGroups);
    }
}
