package com.langpath.mongo.command;

import com.langpath.mongo.model.Word;
import com.langpath.mongo.model.WordGroup;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindWorstAnsweredWordTest {

    FindWorstAnsweredWord command = new FindWorstAnsweredWord();

    @Test
    public void shouldFindWord() {
        Word result = command.findWorstAnsweredGroup(buildEmptyWordGroup());

        assertEquals(null, result);
    }

    private WordGroup buildEmptyWordGroup() {
        return WordGroup.builder().build();
    }

}