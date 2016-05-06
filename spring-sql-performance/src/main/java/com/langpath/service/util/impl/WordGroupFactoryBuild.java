package com.langpath.service.util.impl;

import com.common.service.api.CrudApi;
import com.langpath.data.model.entity.word.WordGroup;
import common.model.enums.Language;
import common.model.enums.ValidationState;
import com.langpath.service.api.WordGroupServiceApi;
import com.common.service.api.EntityFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Sebastian on 2016-04-04.
 */
@Service("wordGroupBuilder")
public class WordGroupFactoryBuild implements EntityFactoryBuilder<WordGroup> {


    @Autowired
    @Qualifier("wordGroupCrudServiceApi")
    private CrudApi<WordGroup, Long> wordGroupService;

    @Override
    public Collection<WordGroup> build(int count) {
        Collection<WordGroup> wordsGr = new ArrayList<>();
        for(int i=0;i<count;i++) {
            wordsGr.add(buildOne());
        }
        wordGroupService.save(wordsGr);
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

        return wordGroup;
    }
}
