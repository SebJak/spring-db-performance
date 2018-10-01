package com.langpath.mongo.command;

import com.langpath.mongo.model.WordGroup;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordGroupInfoTest {

    WordGroupInfo wordGroupInfo = new WordGroupInfo();

    @Test
    public void shouldNotFindUser() throws Throwable {
        WordGroup result = wordGroupInfo.findWorstAnsweredWordGroup("NOT_EXISTS");

        assertEquals(null, result);
    }

    @Test
    public void shouldNotFindGroupForUser() throws Throwable {
        WordGroup result = wordGroupInfo.findWorstAnsweredWordGroup("NOT_HAS_GROUP");

        assertEquals(null, result);
    }

}