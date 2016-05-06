import com.common.service.api.CheckPerformanceApi;
import com.langpath.mongo.MongoApplication;
import com.langpath.mongo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Sebastian on 2016-04-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MongoApplication.class)
@ActiveProfiles(value = "test")
public class UserMongoPerformance {

    @Autowired
    @Qualifier("userMongoPerformance")
    private CheckPerformanceApi<User> userMongoPerformance;

    private final Logger logger = LoggerFactory.getLogger(UserMongoPerformance.class);

    @Test
    public void testSaveOne() throws Exception {
        logger.info("Test save one");
        assertNotNull(userMongoPerformance.saveOne());
    }

    @Test
    public void testSaveCollection() throws Exception {
        logger.info("Test save collection");
        for(int i=0;i<10;i++)
            assertNotNull(userMongoPerformance.saveCollection());
    }

    @Test
    public void testUpdate() throws Exception {
        logger.info("Test update");
        assertNotNull(userMongoPerformance.update());
    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testFindById() throws Exception {
        User u = userMongoPerformance.saveOne();
        //assertNotNull(userMongoPerformance.findById(u.getId()));
    }
}
