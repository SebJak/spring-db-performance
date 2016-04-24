package com.langpath.service.util.impl;

import com.langpath.data.model.entity.word.Word;
import com.langpath.data.model.entity.word.WordGroup;
import common.model.enums.Language;
import com.langpath.service.api.WordServiceApi;
import com.langpath.service.util.api.EntityFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.*;

/**
 * Created by Sebastian on 2016-04-04.
 */
public class WordFactoryBuild implements EntityFactoryBuilder<Word> {

    @Autowired
    private WordServiceApi wordService;

    @Autowired
    @Qualifier("wordGroupBuilder")
    private EntityFactoryBuilder wordGroupBuilder;

    @Override
    public Collection<Word> build(int count) {
        List<WordGroup> wg = new ArrayList<>(wordGroupBuilder.build(1));
        Collection<Word> words= new ArrayList<>();
        for(int i=0;i<count;i++){
            words.add(buildOne(wg.get(0)));
        }
        wordService.save(words);

        return words;
    }

    private Word buildOne(WordGroup wg){
        Random rm = new Random();
        Word word = new Word();
        word.setGoodAnswers(rm.nextInt());
        switch (rm.nextInt()/3){
            case 1:
                word.setLang(Language.DE);
                break;
            case 2:
                word.setLang(Language.PL);
                break;
            case 0:
                word.setLang(Language.EN);
                break;
            default: break;
        }
        word.setLastTraining(new Date());
        word.setValue(UUID.randomUUID().toString());
        word.setWrongAnswers(rm.nextInt());
        word.setWordGroup(wg);

        return word;
    }
}
