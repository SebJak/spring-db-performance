import com.langpath.mongo.model.User;
import com.service.api.CrudApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sebastian on 2016-04-27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(MongoApplication.class)
@ActiveProfiles(value = "test")
public class UserCrudServiceTest {

    @Autowired
    @Qualifier("userCrudService")
    private CrudApi<User, String> userCrudService;

    @Test
    public void createUser(){
        User user = User.builder()
                .email("email.@email.com")
                .firstName("Gregor")
                .lastName("Kowalsky")
                .nick("sss")
                .build();

        Optional<User> saved = userCrudService.save(user);

        assertEquals(saved.isPresent(), true);
        assertEquals(saved.get().getId().isEmpty(), false);
    }

}
