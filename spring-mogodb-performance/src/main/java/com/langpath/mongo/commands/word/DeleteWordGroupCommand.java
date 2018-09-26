package com.langpath.mongo.commands.word;

import com.langpath.mongo.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Created by root on 12.10.16.
 */
@Service
class DeleteWordGroupCommand {

    private UserRepository userRepository;

    public DeleteWordGroupCommand(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    void removeWordGroup(final String userId, final String wordGroupId) {
        userRepository.findById(userId).map(u -> u.removeWordGroup(wordGroupId)).ifPresent(u -> userRepository.save(u));
    }

}
