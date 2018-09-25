package com.langpath.commands;

import com.langpath.AbstractTestContext;
import com.langpath.data.model.entity.user.User;
import com.langpath.data.model.entity.word.WordGroup;
import com.langpath.data.repositories.UserRepository;
import com.langpath.data.repositories.WordGroupRepository;
import com.langpath.data.repositories.WordRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Created by root on 13.10.16.
 */

public class AddWordToWordGroupTest extends AbstractTestContext {

    @Autowired
    AddWordToGroupService service;

    @Test
    public void addWordToGroup() {
        service.setWordGroupOwnerForEachGroup();
    }


}
