package com.langpath.mongo.command;

import com.langpath.mongo.model.Word;
import com.langpath.mongo.model.WordGroup;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

/**
 * Created by root on 14.10.16.
 */
class FindWorstAnsweredWord {

    Word findWorstAnsweredGroup(WordGroup wordGroup) {
        Optional<Word> first = wordGroup.getFishCards().keySet().stream().sorted(Comparator.comparingInt(Word::getAnswers)).findFirst();
        Optional<Word> second = wordGroup.getFishCards().values().stream().sorted(Comparator.comparingInt(Word::getAnswers)).findFirst();
        return ((first.get().getAnswers() - second.get().getAnswers()) > 0) ? second.get() : first.get();
    }
}
