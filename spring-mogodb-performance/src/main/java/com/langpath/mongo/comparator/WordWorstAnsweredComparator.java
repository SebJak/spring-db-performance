package com.langpath.mongo.comparator;

import com.langpath.mongo.model.Word;

import java.util.Comparator;

/**
 * Created by root on 14.10.16.
 */
public class WordWorstAnsweredComparator implements Comparator<Word> {

    @Override
    public int compare(Word word, Word t1) {
        return t1.getAnswers() - word.getAnswers();
    }

}
