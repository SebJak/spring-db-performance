package com.langpath.mongo.commands.word;

import com.langpath.mongo.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Created by root on 12.10.16.
 */
@Service
class DeleteWordGroupCommand {

    private UserRepository wgRepository;

    public DeleteWordGroupCommand(UserRepository wgRepository) {
        this.wgRepository = wgRepository;
    }

    void removeWordGroup(final String userId, final String wordGroupId) {
        wgRepository.findById(userId).map(u -> u.removeWordGroup(wordGroupId)).ifPresent(u -> wgRepository.save(u));
    }

}
