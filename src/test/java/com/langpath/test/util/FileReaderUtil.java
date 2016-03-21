package com.langpath.test.util;

import com.langpath.sql.model.entity.word.Word;
import com.langpath.sql.model.entity.word.WordGroup;
import com.langpath.sql.model.enums.Language;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sebastian on 2016-03-19.
 */
public class FileReaderUtil {

    private final Path FILE_PATH;

    public FileReaderUtil(String fileName) {
        this.FILE_PATH = Paths.get(fileName);
    }

    public List<String> readLines(int count) {
        assert FILE_PATH == null : "The FILE_PATH is null, You need to initialize FileReaderUtil.";
        List<String> lines = new ArrayList<>();
        try {
            Files.lines(FILE_PATH).limit(count).forEach(line -> lines.add(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public Map<Word, Word> readWords(int count) {
        assert FILE_PATH == null : "The FILE_PATH is null, You need to initialize FileReaderUtil.";
        Map<Word, Word> words = new HashMap<>();
        List<String> stringWords = readLines(count);
        WordGroup wordGroup = new WordGroup();
        wordGroup.setName("Word Group");
        wordGroup.setSourceLang(Language.PL);
        stringWords.stream().forEach(line -> {
            String[] splitedLine = line.split("::");
            Word w1 = new Word();
            w1.setLang(Language.EN);
            w1.setValue(splitedLine[0]);
            w1.setWordGroup(wordGroup);

            Word w2 = new Word();
            w2.setLang(Language.PL);
            w2.setValue(splitedLine[1]);
            w2.setWordGroup(wordGroup);

            words.put(w1,w2);
        });

        return words;
    }
}
