package com.langpath.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Sebastian on 2016-03-19.
 */
@Service
public class FileReaderUtil {

    private final Path FILE_PATH;

    private final static int lineNumber = 5824;

    @Autowired
    public FileReaderUtil(@Value("${words.fileName}") final String fileName) {
        this.FILE_PATH = Paths.get(fileName);
    }

    public List<String> readLines(int count) {
        assert FILE_PATH != null : "The FILE_PATH is null, You need to initialize FileReaderUtil.";
        List<String> lines = new ArrayList<>();
        try {
            Files.lines(FILE_PATH).limit(count).forEach(lines::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public List<String> readRandomLines(int count) {
        assert FILE_PATH != null : "The FILE_PATH is null, You need to initialize FileReaderUtil.";
        List<String> returnLines = new ArrayList<>();
        int randomLine = (int )(Math.random() * (lineNumber - count));
        try {
            try (Stream<String> lines = Files.lines(FILE_PATH)) {
                lines.skip(randomLine).limit(count).forEach(returnLines::add);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnLines;
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
