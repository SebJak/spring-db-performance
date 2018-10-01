package com.langpath.commands;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by root on 13.10.16.
 */
public class SetGroupOwnerTest {

    @Autowired
    private SetGroupOwner setGroupOwner;

    @Test
    public void setWordGroupOwnerForEachGroup() throws Exception {
        setGroupOwner.setWordGroupOwnerForEachGroup();
    }

}