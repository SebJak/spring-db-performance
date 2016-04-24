package com.langpath.neo4j;

import static org.junit.Assert.*;

import com.common.service.impl.CrudImpl;
import com.langpath.neo4j.model.Word;
import common.model.enums.Language;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Sebastian on 2016-04-23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Neo4jApplication.class)
@ActiveProfiles(value = "test")
public class CrudServiceTests {

    @Autowired
    @Qualifier("wordCrudService")
    CrudImpl<Word, Long> wordCrudService;

    @Test
    public void createWordTest() {
        Word w = new Word();
        w.setValue("Value");
        w.setGoodAnswers(0);
        w.setBadAnswers(0);
        w.setLanguage(Language.EN);
        assertTrue(wordCrudService.save(w).isPresent());

    }
}
