package com.langpath.commands;

import com.langpath.data.model.entity.word.Word;
import com.langpath.data.model.entity.word.WordGroup;
import com.langpath.data.repositories.WordGroupRepository;
import com.langpath.data.repositories.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by
 * root on 11.10.16.
 */
@Service
public class AddWordToGroupService {

    private WordRepository wordRepository;

    public AddWordToGroupService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    private void addWordsToGroup(final Iterable<Word> words, final WordGroup wordGroup) {
        words.forEach(
                w -> w.setWordGroup(wordGroup)
        );
        wordRepository.save(words);
    }

    public void addWordToGroup(Word word, final WordGroup wordGroup) {
        addWordsToGroup(Arrays.asList(word), wordGroup);
    }


    void setWordGroupOwnerForEachGroup() {
        Page<Word> wordsPage = wordRepository.findAll(new PageRequest(1, 100));
        for (int i = 0; i < wordsPage.getTotalPages(); i++) {
            List<Word> words = wordsPage.getContent();
            words.forEach(word -> {
                if (word.getWordGroup() == null && word.getSource() != null && word.getSource().getWordGroup()!= null) {
                    word.setWordGroup(word.getSource().getWordGroup());
                }
            });
            wordRepository.save(words);
        }
    }
    }
