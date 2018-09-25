package com.langpath.mongo.comparator;

import com.langpath.mongo.model.FishCard;
import com.langpath.mongo.model.Word;

import java.util.Comparator;
import java.util.Optional;

/**
 * Created by root on 14.10.16.
 */
public class FishCardWrongAnswerComparator implements Comparator<FishCard> {

    @Override
    public int compare(FishCard fishCard, FishCard t1) {
        Optional<Word> w = fishCard.getMeanings().stream().sorted(new WordWorstAnsweredComparator()).findFirst();
        Optional<Word> w2 = t1.getMeanings().stream().sorted(new WordWorstAnsweredComparator()).findFirst();
        return w2.get().getWrongAnswers() - w.get().getWrongAnswers();
    }
}
