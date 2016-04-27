import com.langpath.mongo.MongoApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Sebastian on 2016-04-27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MongoApplication.class)
@ActiveProfiles(value = "test")
public class UserCrudServiceTest {

}
