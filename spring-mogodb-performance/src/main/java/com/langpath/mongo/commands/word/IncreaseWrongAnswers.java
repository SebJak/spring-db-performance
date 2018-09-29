package com.langpath.mongo.commands.word;

import com.langpath.mongo.model.WordGroup;
import com.langpath.mongo.repository.WordGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by root on 11.10.16.
 */
@Service
class IncreaseWrongAnswers {

    @Autowired
    private WordGroupRepository repository;

    void updateAnswers(final String wgId, final String value) {
        Optional<WordGroup> wordGroup = repository.findById(wgId);
        wordGroup.map(wg -> {
            List<FishCard> fishCards = new ArrayList<>(wordGroup.get().getFishCards());
            fishCards.forEach(fishCard -> {
                if(fishCard.getWord().getValue() != null && fishCard.getWord().getValue().equals(value)){
                    fishCard.getWord().setAnswers(fishCard.getWord().getAnswers() + 1);
                }
                else{
                    fishCard.getMeanings().forEach(word -> {
                        if(word.getValue() != null && word.getValue().equals(value)){
                            word.setAnswers(word.getAnswers()+1);
                        }
                    });
                }
            });
            return repository.save(wg);
        });
    }
}
