package com.langpath.mongo.commands.word;

import com.langpath.mongo.model.User;
import com.langpath.mongo.repository.UserRepository;
import com.service.api.CrudApi;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by root on 12.10.16.
 */
@Service
class DeleteWordGroupCommand {

    private CrudApi<User, String> userCrud;

    public DeleteWordGroupCommand(@Qualifier("userCrudService") CrudApi userCrud) {
        this.userCrud = userCrud;
    }

    void removeWordGroup(final String userId, final String wordGroupId) {
        userCrud.findById(userId).flatMap(u -> Optional.of(u.removeWordGroup(wordGroupId))).ifPresent(u -> userCrud.save(u));
    }

}
