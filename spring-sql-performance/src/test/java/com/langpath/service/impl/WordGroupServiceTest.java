package com.langpath.service.impl;

import com.langpath.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

/**
 * Created by Sebastian on 2016-03-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class WordGroupServiceTest {

    @Autowired
    private WordGroupService service;

    @org.junit.Test
    public void testSave() throws Exception {

    }

    @org.junit.Test
    public void testUpdate() throws Exception {

    }

    @org.junit.Test
    public void testFindById() throws Exception {

    }

    @org.junit.Test
    public void testFindAll() throws Exception {

    }

    @org.junit.Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testSave1() throws Exception {

    }

    @Test
    public void testSave2() throws Exception {

    }

    @Test
    public void testUpdate1() throws Exception {

    }

    @Test
    public void testFindById1() throws Exception {

    }

    @Test
    public void testFindAll1() throws Exception {

    }

    @Test
    public void testRemove1() throws Exception {

    }

    @Test
    public void testGetRandom() throws Exception {

    }

    @Test
    public void testGetAggregationWordGroup() throws Exception {
        Collection<AggregationWordGroup> wg = service.getAggregationWordGroup();
        System.out.println(wg);
    }
}