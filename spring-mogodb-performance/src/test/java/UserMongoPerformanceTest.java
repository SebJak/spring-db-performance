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
public class UserMongoPerformanceTest {

    @Autowired
    @Qualifier("userMongoPerformance")
    private CheckPerformanceApi<User> userMongoPerformance;

    private final Logger logger = LoggerFactory.getLogger(UserMongoPerformanceTest.class);

    @Test
    public void testSaveOne() throws Exception {
        logger.info("Test save one");
        //for(int i=0;i<1000; i++)
            assertNotNull(userMongoPerformance.saveOne());
    }

    @Test
    public void  testSaveCollection() throws Exception {
        logger.info("Test save collection");
        //for(int i=0;i<1000;i++)
            assertNotNull(userMongoPerformance.saveCollection());
    }

    @Test
    public void testUpdate() throws Exception {
        logger.info("Test updateOne");
        assertNotNull(userMongoPerformance.updateOne());
    }

    @Test
    public void testRemove() throws Exception {
        logger.info("Test remove");
        //for(int i=0;i<100;i++)
            assertNotNull(userMongoPerformance.remove());
    }
}
