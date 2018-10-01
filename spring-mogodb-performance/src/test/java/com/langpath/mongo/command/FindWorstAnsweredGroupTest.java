package com.langpath.mongo.command;

import com.langpath.mongo.model.User;
import com.langpath.mongo.model.WordGroup;
import com.model_old.enums.Role;
import org.junit.Test;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Created by root on 14.10.16.
 */
public class FindWorstAnsweredGroupTest {

    private FindWorstAnsweredGroup command = new FindWorstAnsweredGroup();

    @Test
    public void shouldNotFindGroupForUser() {
        Optional<WordGroup> result = command.findWorstAnsweredGroup(userWithNoGroups());

        assertEquals(Optional.empty(), result);
    }

    @Test
    public void shouldFindGroupForUser() {
        Optional<WordGroup> result = command.findWorstAnsweredGroup(userWithGroups());

        assertEquals(true, result.isPresent());
    }

    @Test
    public void shouldFindWorstGroupUser() {
        Optional<WordGroup> result = command.findWorstAnsweredGroup(userWithCollectionGroups());

        assertEquals(true, result.isPresent());
        assertEquals("test_02", result.get().getId());
    }

    private User userWithCollectionGroups() {
        WordGroup wordGroup = WordGroup.builder()
                .id("test_02")
                .positiveAnswers(-1L).build();
        return userWithGroups().addWordGroup(wordGroup);
    }

    private User userWithGroups() {
        WordGroup wordGroup = WordGroup.builder()
                .id("test_01")
                .positiveAnswers(1L).build();
        return userWithNoGroups().addWordGroup(wordGroup);
    }

    private User userWithNoGroups() {
        return User.builder()
                .nick("Steven_007")
                .email("steven.test@email.com")
                .firstName("Steven")
                .lastName("Test")
                .password("PWD")
                .role(Role.STUDENT)
                .wordGroups(new HashMap<>())
                .build();
    }

}