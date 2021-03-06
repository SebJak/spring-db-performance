package com.langpath.neo4j.service.impl.util;

import com.service.api.CrudApi;
import com.service.api.EntityFactoryBuilder;
import com.langpath.neo4j.model.WordGroup;
import com.model_old.enums.Language;
import com.model_old.enums.ValidationState;
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
@Service("wordGroupFactoryBuilder")
public class WordGroupFactoryBuild implements EntityFactoryBuilder<WordGroup> {


    @Autowired
    @Qualifier("wordGroupCrudService")
    private CrudApi<WordGroup,Long> wordGroupCrudService;

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
        Random rm = new Random();
        switch (rm.nextInt()%3){
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
