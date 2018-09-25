package com.langpath.commands;

import com.langpath.data.model.entity.word.Word;
import com.langpath.data.model.entity.word.WordGroup;
import com.langpath.data.repositories.WordGroupRepository;
import com.langpath.data.repositories.WordRepository;
import com.langpath.service.util.FileReaderUtil;
import com.model_old.enums.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by root on 11.10.16.
 */
@Service
public class UploadWordsFromFIle extends AbstractCommand {

    private WordGroupRepository wordGroupRepository;

    private WordRepository wordRepository;

    private FileReaderUtil fileReaderUtil;

    public UploadWordsFromFIle(WordGroupRepository wordGroupRepository, WordRepository wordRepository, FileReaderUtil fileReaderUtil) {
        this.wordGroupRepository = wordGroupRepository;
        this.wordRepository = wordRepository;
        this.fileReaderUtil = fileReaderUtil;
    }

    void addWordsToEachWordGroup() {
        final int count = 15;
        timeLogger.start();
        Page<WordGroup> wgs = wordGroupRepository.findAll(new PageRequest(1, 100));
        wgs.forEach(wordGroup -> {
            List<String> wordValues = fileReaderUtil.readRandomLines(count);
            List<Word> words = new ArrayList<>();
            for(int i=0;i<count;i++){
                String[] values = wordValues.get(i).split("::");
                words.addAll(buildOneCouple(values[1], values[0]));
            }
            wordRepository.save(words);
        });
        timeLogger.logTime("AddWords", wgs.getNumberOfElements());
    }

    private List<Word> buildOneCouple(String sourceValue, String targetValue){
        Random rm = new Random();
        Word source = new Word();
        source.setGoodAnswers(rm.nextInt(50));
        source.setLang(Language.PL);
        source.setLastTraining(new Date());
        source.setValue(sourceValue);
        source.setWrongAnswers(rm.nextInt(50));

        Word target = new Word();
        target.setGoodAnswers(rm.nextInt(50));
        target.setLang(Language.EN);
        target.setLastTraining(new Date());
        target.setValue(targetValue);
        target.setWrongAnswers(rm.nextInt(50));
        target.setSource(source);

        return Arrays.asList(source, target);
    }

}
