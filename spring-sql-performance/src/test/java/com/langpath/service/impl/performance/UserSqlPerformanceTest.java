package com.langpath.service.impl.performance;

import com.langpath.Application;
import com.langpath.data.model.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;


/**
 * Created by Sebastian on 2016-04-06.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@ActiveProfiles(value = "test")
public class UserSqlPerformanceTest {

    @Autowired
    @Qualifier("userSqlPerformance")
    private CheckPerformanceApi<User> userSqlPerformance;

    @Test
    public void testSaveOne() throws Exception {
        for(int i=0;i<1000;i++)
            assertNotNull(userSqlPerformance.saveOne());
    }

    @Test
    public void testSaveCollection() throws Exception {
        for(int i=0;i<100;i++)
            assertNotNull(userSqlPerformance.saveCollection());
    }

    @Test
    public void testUpdate() throws Exception {
        for(int i=0;i<1000;i++)
            assertNotNull(userSqlPerformance.updateOne());
    }

    @Test
    public void testUpdateCollection() throws Exception {
        for(int i=0;i<100;i++)
            assertNotNull(userSqlPerformance.updateCollection());
    }

    @Test
    public void testRemove() throws Exception {
        for(int i=0;i<100;i++)
            assertNotNull(userSqlPerformance.remove());
    }

    @Test
    public void testFindById() throws Exception {
        User user= userSqlPerformance.saveOne();
        assertNotNull(userSqlPerformance.findById(user.getId()));
    }

}