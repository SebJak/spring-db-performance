package com.langpath.commands;

import com.langpath.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by root on 11.10.16.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
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