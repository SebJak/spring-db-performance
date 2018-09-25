package com.langpath.commands;

import com.langpath.Application;
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
@SpringApplicationConfiguration(Application.class)
@ActiveProfiles(value = "test")
public class UploadWordsFromFIleTest {

    @Autowired
    private UploadWordsFromFIle uploader;

    @Test
    public void addWordsToGroups() {
        for(int i=0;i<1;i++)
        uploader.addWordsToEachWordGroup();
    }
}