package com.langpath.neo4j.commands.help;

import com.langpath.neo4j.Neo4jApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by root on 11.10.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Neo4jApplication.class)
@ActiveProfiles(value = "test")
public class UploadWordsFromFileTest {

    @Autowired
    UploadWordsFromFile uploadWordsFromFile;

    @Test
    public void addWordsToEachWordGroup() throws Exception {
        uploadWordsFromFile.addWordsToEachWordGroup();
    }

}