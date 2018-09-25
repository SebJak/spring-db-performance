package com.langpath.commands;

import com.langpath.AbstractTestContext;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by root on 13.10.16.
 */
public class SetGroupOwnerTest extends AbstractTestContext{

    @Autowired
    private SetGroupOwner setGroupOwner;

    @Test
    public void setWordGroupOwnerForEachGroup() throws Exception {
        setGroupOwner.setWordGroupOwnerForEachGroup();
    }

}