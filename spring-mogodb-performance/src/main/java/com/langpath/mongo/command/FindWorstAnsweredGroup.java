package com.langpath.mongo.command;

import com.langpath.mongo.model.User;
import com.langpath.mongo.model.WordGroup;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

/**
 * Created by root on 14.10.16.
 */
@Service
class FindWorstAnsweredGroup {

    Optional<WordGroup> findWorstAnsweredGroup(User user) {
        return user.getWordGroups()
                .values()
                .stream()
                .sorted(Comparator.comparingLong(WordGroup::getPositiveAnswers))
                .findFirst();
    }
}
