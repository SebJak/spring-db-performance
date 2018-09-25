package com.langpath.neo4j.service.impl.util;

import com.langpath.neo4j.Neo4jApplication;
import com.langpath.neo4j.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Sebastian on 2016-04-25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Neo4jApplication.class)
@ActiveProfiles(value = "test")
public class UserNeo4jPerformanceTest {

    @Autowired
    @Qualifier("userNeo4jPerformance")
    private CheckPerformanceApi<User> userNeo4jPerformance;

    @Test
    public void testSaveOne() throws Exception {
        for(int i=0;i<2500;i++)
            assertNotNull(userNeo4jPerformance.saveOne());
    }

    @Test
    public void testSaveCollection() throws Exception {
        for(int i=0;i<100;i++)
            assertNotNull(userNeo4jPerformance.saveCollection());
    }

    @Test
    public void testUpdate() throws Exception {
        assertNotNull(userNeo4jPerformance.updateOne());
    }

    @Test
    public void testRemove() throws Exception {
        for(int i=0;i<1000;i++)
            userNeo4jPerformance.remove();
        assertTrue(true);
    }

    //@Test
    public void testFindById() throws Exception {
        User u = userNeo4jPerformance.saveOne();
        //assertNotNull(userNeo4jPerformance.findById(u.getId()));
    }

}