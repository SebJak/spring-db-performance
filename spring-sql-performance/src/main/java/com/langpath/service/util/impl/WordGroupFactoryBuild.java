package com.langpath.service.util.impl;

import com.service.api.CrudApi;
import com.google.common.collect.Lists;
import com.langpath.data.model.entity.word.Word;
import com.langpath.data.model.entity.word.WordGroup;
import com.model_old.enums.Language;
import com.service.api.EntityFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

/**
 * Created by Sebastian on 2016-04-04.
 */
@Service("wordGroupBuilder")
public class WordGroupFactoryBuild implements EntityFactoryBuilder<WordGroup> {


    @Autowired
    @Qualifier("wordGroupCrudService")
    private CrudApi<WordGroup, Long> wordGroupService;

    @Autowired
    @Qualifier("wordCrudService")
    private CrudApi<Word, Long> wordService;

    @Autowired
    @Qualifier("wordBuilder")
    private EntityFactoryBuilder wordBuilder;

    @Override
    public Collection<WordGroup> buildAndPersist(int count) {
        Collection<WordGroup> wordsGr = build(count);
         return Lists.newArrayList(wordGroupService.save(wordsGr).get());
    }

    @Override
    public Collection<WordGroup> build(int count) {
        Collection<WordGroup> wordsGr = new ArrayList<>();
        for(int i=0;i<count;i++) {
            wordsGr.add(buildOne());
        }
        return wordsGr;
    }

    private WordGroup buildOne(){
        WordGroup wordGroup = new WordGroup();
        wordGroup.setDescription("Description");
        wordGroup.setName("Name_"+ UUID.randomUUID());
        wordGroup.setSourceLang(Language.PL);
        Iterable<Word> words = wordBuilder.build(15);
        final WordGroup saved = wordGroupService.save(wordGroup).get();
        words.forEach(w -> w.setWordGroup(saved));
        wordService.save(words);//FIXME not set the id of wordGroup because it is generated value during saving data.
        return wordGroup;
    }
}
