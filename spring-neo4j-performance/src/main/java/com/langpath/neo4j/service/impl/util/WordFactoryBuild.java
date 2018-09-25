package com.langpath.neo4j.service.impl.util;

import com.service.api.CrudApi;
import com.service.api.EntityFactoryBuilder;
import com.langpath.neo4j.model.Word;
import com.langpath.neo4j.model.WordGroup;
import com.model_old.enums.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Sebastian on 2016-04-04.
 */
@Service("wordFactoryBuilder")
public class WordFactoryBuild implements EntityFactoryBuilder<Word> {

    @Autowired
    @Qualifier("wordCrudService")
    private CrudApi<Word, Long> wordCrudService;

    @Autowired
    @Qualifier("wordGroupFactoryBuilder")
    private EntityFactoryBuilder wordGroupBuilder;

    @Override
    public Collection<Word> buildAndPersist(int count) {
        List<WordGroup> wg = new ArrayList<>(wordGroupBuilder.buildAndPersist(1));
        Collection<Word> words= new ArrayList<>();
        for(int i=0;i<count;i++){
            words.add(buildOne(wg.get(0)));
        }
        wordCrudService.save(words);

        return words;
    }

    @Override
    public Collection<Word> build(int count) {
        return null;
    }

    private Word buildOne(WordGroup wg){
        Random rm = new Random();
        Word word = new Word();
        word.setGoodAnswers(rm.nextInt());
        switch (rm.nextInt()/3){
            case 1:
                word.setLanguage(Language.DE);
                break;
            case 2:
                word.setLanguage(Language.PL);
                break;
            case 0:
                word.setLanguage(Language.EN);
                break;
            default: break;
        }
        word.setValue(UUID.randomUUID().toString());
        word.setGoodAnswers(rm.nextInt());
        word.setWordGroup(wg);

        return word;
    }
}
