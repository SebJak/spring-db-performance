import com.common.service.api.CrudApi;
import com.langpath.mongo.MongoApplication;
import com.langpath.mongo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    @Qualifier("userCrudService")
    private CrudApi<User, Long> userCrudService;

    @Test
    public void createUser(){
        User user = new User();
        user.setEmail("email.@email.com");
        user.setFirstName("Gregor");
        user.setLastName("Kowalsky");
        user.setNick("sss");
        userCrudService.save(user);
    }



}
