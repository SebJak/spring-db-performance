package com.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Paths.get;
import static java.util.stream.Collectors.toList;

/**
 * Created by Sebastian on 2016-03-19.
 */
@Slf4j
@Service
public class FileReaderUtil {

    public List<String> readLines(final String filePath, int count) {
        try {
            return Files.lines(get(filePath)).limit(count).collect(toList());
        } catch (IOException e) {
            log.error("Error during reading count of line {} from file {}\n {} ", count, filePath, e);
        }
        return Collections.emptyList();
    }

    @Deprecated
    public List<String> readRandomLines(final String filePath, int count) {
        int randomLine = (int )(Math.random() * (5824 - count));
        try {
            try (Stream<String> lines = Files.lines(get(filePath))) {
                return lines.skip(randomLine).limit(count).collect(toList());
            }
        } catch (IOException e) {
            log.error("Error during reading count of line {} from file {}\n {} ", count, filePath, e);
        }
        return Collections.emptyList();
    }

//    public Collection<Word> readWords(int count) {
//        assert FILE_PATH != null : "The FILE_PATH is null, You need to initialize FileReaderUtil.";
//        Collection<Word> words = new ArrayList<>();
//        Optional<WordGroup> wordGroupOpt = wordGroupService.getRandom();
//        WordGroup wordGroup;
//        if(wordGroupOpt.isPresent()) {
//            wordGroup = wordGroupOpt.get();
//        }
//        else{
//            wordGroup = new WordGroup();
//            wordGroup.setName("Word Group");
//            wordGroup.setSourceLang(Language.PL);
//            wordGroupService.save(wordGroup);
//        }
//        List<String> stringWords = readLines(count);
//
//        stringWords.stream().forEach(line -> {
//            String[] splitedLine = line.split("::");
//            Word w1 = new Word();
//            w1.setLang(Language.EN);
//            w1.setValue(splitedLine[0]);
//            w1.setWordGroup(wordGroup);
//
//            Word w2 = new Word();
//            w2.setLang(Language.PL);
//            w2.setValue(splitedLine[1]);
//            w2.setWordGroup(wordGroup);
//            w2.setSource(w1);
//
//            words.add(w1);
//            words.add(w2);
//        });
//
//        return words;
//    }
}
