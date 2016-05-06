package com.langpath.mongo.service.util.impl;

import com.common.service.api.CrudApi;
import com.common.service.api.EntityFactoryBuilder;
import com.langpath.mongo.model.FishCard;
import com.langpath.mongo.model.Word;
import com.langpath.mongo.model.WordGroup;
import common.model.enums.Language;
import common.model.enums.ValidationState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Sebastian on 2016-04-04.
 */
@Service("wordGroupFactoryBuilder")
public class WordGroupFactoryBuilder implements EntityFactoryBuilder<WordGroup> {


    @Autowired
    @Qualifier("wordGroupCrudService")
    private CrudApi<WordGroup,Long> wordGroupCrudService;

    @Autowired
    @Qualifier("wordFactoryBuilder")
    private EntityFactoryBuilder wordFactoryBuilder;

    @Override
    public Collection<WordGroup> build(int count) {
        Collection<WordGroup> wordsGr = new ArrayList<>();
        for(int i=0;i<count;i++) {
            wordsGr.add(buildOne());
        }
        wordGroupCrudService.save(wordsGr);
        return wordsGr;
    }

    private WordGroup buildOne(){
        WordGroup wordGroup = new WordGroup();
        wordGroup.setDescription("Description");
        wordGroup.setName("Name_"+ UUID.randomUUID());
        Random rm = new Random();
        switch (rm.nextInt()/3){
            case 0:
                wordGroup.setValidation(ValidationState.WARNING);
                wordGroup.setSourceLang(Language.DE);
                break;
            case 1:
                wordGroup.setValidation(ValidationState.ERROR);
                wordGroup.setSourceLang(Language.EN);
                break;
            case 2:
                wordGroup.setValidation(ValidationState.GOOD);
                wordGroup.setSourceLang(Language.PL);
                break;
            default:
                break;
        }
        wordGroup.setCreatedDate(new Date());
        wordGroup.setFishCards(buildFishCards(20));
        wordGroup.setLastActivity(new Date());

        return wordGroup;
    }

    private Collection<FishCard> buildFishCards(int count) {
        Collection<FishCard> fishCards = new ArrayList<>();
        FishCard tmp = null;
        List<Word> words = new ArrayList<>(wordFactoryBuilder.build(3));
        Map<Language, Word> wordsMap = new HashMap<>();
        for (int i = 1; i < words.size(); i++) {
            if (i % 3 == 1)
                wordsMap.put(Language.DE, words.get(i));
            if (i % 3 == 2)
                wordsMap.put(Language.EN, words.get(i));
        }
        for (int i = 0; i < count; i++) {
            tmp = new FishCard();
            tmp.setWord(words.get(0));
            tmp.setMeanings(wordsMap);
            fishCards.add(tmp);
        }
        return  fishCards;
    }
}
