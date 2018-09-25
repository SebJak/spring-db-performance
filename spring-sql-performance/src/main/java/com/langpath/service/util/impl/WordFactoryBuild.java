package com.langpath.service.util.impl;

import com.service.api.CrudApi;
import com.google.common.collect.Lists;
import com.langpath.data.model.entity.word.Word;
import com.langpath.service.util.FileReaderUtil;
import com.model_old.enums.Language;
import com.service.api.EntityFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Sebastian on 2016-04-04.
 */
@Service("wordBuilder")
public class WordFactoryBuild implements EntityFactoryBuilder<Word> {

    @Autowired
    @Qualifier("wordCrudService")
    private CrudApi<Word, Long> wordCrudServiceApi;

    @Autowired
    private FileReaderUtil fileReaderUtil;

    @Override
    public Collection<Word> buildAndPersist(int count) {
        Collection<Word> words =  build(count);
        wordCrudServiceApi.save(words);
        return words;
    }

    @Override
    public Collection<Word> build(int count) {

        Collection<Word> words= new ArrayList<>();
        List<String> wordValues = fileReaderUtil.readLines(count);
        for(int i=0;i<count;i++){
            String[] values = wordValues.get(i).split("::");
            words.addAll(buildOne(values[1], values[0]));
        }

        return words;
    }

    private List<Word> buildOne(String sourceValue, String targetValue){
        List<Word> wordPair = new ArrayList<>();
        Random rm = new Random(100);
        Word source = new Word();
        source.setGoodAnswers(0);
        source.setLang(Language.PL);
        source.setLastTraining(null);
        source.setValue(sourceValue);
        source.setWrongAnswers(rm.nextInt(50));
        //source = wordCrudServiceApi.save(source).get();
        System.out.println("SOURCE------ "+ source.getId());
        wordPair.add(source);

        Word target = new Word();
        target.setGoodAnswers(0);
        target.setLang(Language.EN);
        target.setLastTraining(null);
        target.setValue(targetValue);
        target.setWrongAnswers(rm.nextInt(50));
        target.setSource(source);
        //target = wordCrudServiceApi.save(target).get();
        return Lists.newArrayList(wordCrudServiceApi.save(Arrays.asList(source, target)).get());
//        System.out.println("TARGET------ "+target.getId());
//        wordPair.add(target);
//        return  wordPair;
    }
}
