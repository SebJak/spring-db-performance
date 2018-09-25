package com.langpath.mongo.service.util.impl;

import com.service.api.EntityFactoryBuilder;
import com.langpath.mongo.model.Word;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Sebastian on 2016-04-04.
 */
@Service("wordFactoryBuilder")
public class WordFactoryBuilder implements EntityFactoryBuilder<Word> {


    @Override
    public Collection<Word> buildAndPersist(int count) {
        Collection<Word> words= new ArrayList<>();
        for(int i=0;i<count;i++){
            words.add(buildOne());
        }

        return words;
    }

    @Override
    public Collection<Word> build(int count) {
        return null;
    }

    private Word buildOne(){
        Word word = new Word();
        word.setValue(UUID.randomUUID().toString());
//        word.setId(UUID.randomUUID().toString());
        word.setExample("Example sentence.");
        return word;
    }
}
