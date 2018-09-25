package com.langpath.mongo.service.util.impl;

import com.service.api.CrudApi;
import com.service.api.EntityFactoryBuilder;
import com.service.impl.FileReaderUtil;
import com.langpath.mongo.model.FishCard;
import com.langpath.mongo.model.Word;
import com.langpath.mongo.model.WordGroup;
import com.model_old.enums.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Sebastian on 2016-04-04.
 */
@Service("wordGroupFactoryBuilder")
public class WordGroupFactoryBuilder implements EntityFactoryBuilder<WordGroup> {


    @Autowired
    @Qualifier("wordGroupCrudService")
    private CrudApi<WordGroup,String> wordGroupCrudService;

    @Autowired
    @Qualifier("wordFactoryBuilder")
    private EntityFactoryBuilder wordFactoryBuilder;

    @Autowired
    private FileReaderUtil fileReaderUtil;

    @Override
    public Collection<WordGroup> buildAndPersist(int count) {
        Collection<WordGroup> wordsGr = new ArrayList<>();
        for(int i=0;i<count;i++) {
            wordsGr.add(buildOne());
        }
        wordGroupCrudService.save(wordsGr);
        return wordsGr;
    }

    @Override
    public Collection<WordGroup> build(int count) {
        return null;
    }

    private WordGroup buildOne(){
        WordGroup wordGroup = new WordGroup();
        wordGroup.setDescription("Description");
        wordGroup.setName("Name_"+ UUID.randomUUID());

        wordGroup.setCreatedDate(new Date());
        wordGroup.setFishCards(buildFishCards(20));
        wordGroup.setLastActivity(new Date());

        return wordGroup;
    }

    private Collection<FishCard> buildFishCards(int count) {
        Collection<FishCard> fishCards = new ArrayList<>();
        FishCard tmp = null;

        for (int i = 0; i < count; i++) {
            List<String> wordValues = fileReaderUtil.readLines(count);
            for(int k=0;k<count;k++){
                String[] values = wordValues.get(i).split("::");
                tmp = new FishCard();
                tmp.setWord(getWord(values[0], Language.EN));
                tmp.setMeanings(Arrays.asList(getWord(values[1], Language.PL)));
                fishCards.add(tmp);
            }

            fishCards.add(tmp);
        }
        return  fishCards;
    }

    private Word getWord(String value, Language lang) {
        Random rm = new Random();

        Word word = new Word();
        word.setValue(value);
        word.setWrongAnswers(rm.nextInt(50));
        word.setLang(lang);
        return word;
    }
}
