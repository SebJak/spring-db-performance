package com.langpath.neo4j.commands.help;

import com.service.impl.FileReaderUtil;
import com.langpath.neo4j.model.Word;
import com.langpath.neo4j.model.WordGroup;
import com.langpath.neo4j.repositories.WordGroupRepository;
import com.langpath.neo4j.repositories.WordRepository;
import com.model_old.enums.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by root on 11.10.16.
 */
@Service
public class UploadWordsFromFile {

    @Autowired
    private WordGroupRepository wordGroupRepository;

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private FileReaderUtil fileReaderUtil;

    @Autowired
    @Lazy
    @Qualifier("neo4jTimeLogger")
    private TimeLogger timeLogger;

    public void addWordsToEachWordGroup() {
        final int count = 15;
        timeLogger.start();
        Page<WordGroup> wgs = wordGroupRepository.findAll(new PageRequest(1, 100));
        wgs.forEach(wordGroup -> {
            List<String> wordValues = fileReaderUtil.readRandomLines(count);
            List<Word> words = new ArrayList<>();
            for(int i=0;i<count;i++){
                String[] values = wordValues.get(i).split("::");
                words.addAll(buildOneCouple(wordGroup, values[1], values[0]));
            }
            wordRepository.saveAll(words);
        });
        System.out.println(wgs.getTotalElements());
        timeLogger.logTime("AddWords", wgs.getTotalPages());
    }

    private List<Word> buildOneCouple(WordGroup wg, String sourceValue, String targetValue){
        Random rm = new Random();
        Word source = new Word();
        source.setGoodAnswers(rm.nextInt(50));
        source.setBadAnswers(rm.nextInt(50));
        source.setLanguage(Language.PL);
        source.setValue(sourceValue);
        source.setWordGroup(wg);

        Word meaning = new Word();
        meaning.setGoodAnswers(rm.nextInt(50));
        meaning.setBadAnswers(rm.nextInt(50));
        meaning.setLanguage(Language.EN);
        meaning.setValue(targetValue);
        meaning.setWordGroup(wg);

        return Arrays.asList(source, meaning);
    }
}
