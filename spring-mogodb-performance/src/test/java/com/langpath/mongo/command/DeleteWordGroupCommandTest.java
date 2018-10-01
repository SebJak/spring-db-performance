package com.langpath.mongo.command;

import com.langpath.mongo.model.User;
import com.langpath.mongo.model.WordGroup;
import com.service.api.CrudApi;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Optional;

/**
 * Created by root on 12.10.16.
 */

@RunWith(SpringRunner.class)
@ContextConfiguration
public class DeleteWordGroupCommandTest {

    @Autowired
    DeleteWordGroupCommand command;

    @Autowired
    private CrudApi<User, String> userCrud;


    @Test
    public void shouldRemoveWordGroup() throws Exception {
        //given
        ObjectId id = new ObjectId();
        User user = mockUser(id);
        Mockito.when(userCrud.findById(id.toHexString())).thenReturn(Optional.of(user));
        //when
        command.removeWordGroup(id.toHexString(), id.toHexString());
        //then
        Assert.assertEquals(0, user.getWordGroups().size());
    }

    @Test
    public void shouldNotFindWordGroup() throws Exception {
        //given
        ObjectId id = new ObjectId();
        User user = mockUser(id);
        Mockito.when(userCrud.findById(id.toHexString())).thenReturn(Optional.of(user));
        //when
        command.removeWordGroup(id.toHexString(), new ObjectId().toHexString());
        //then
        Assert.assertEquals(1, user.getWordGroups().size());
    }

    @Test
    public void shouldNotFindUser() throws Exception {
        //given
        ObjectId id = new ObjectId();
        User user = mockUser(id);
        Mockito.when(userCrud.findById(Matchers.anyString())).thenReturn(Optional.empty());
        //when
        command.removeWordGroup(new ObjectId().toHexString(), id.toHexString());
        //then
        Assert.assertEquals(1, user.getWordGroups().size());
    }

    @Configuration
    static class Config {

        @Bean
        CrudApi<User, String> userCrudService() {
            return Mockito.mock(CrudApi.class);
        }

        @Bean
        DeleteWordGroupCommand deleteWordGroupCommand(CrudApi crudApi) {
            return new DeleteWordGroupCommand(crudApi);
        }
    }

    private User mockUser(ObjectId id) {
        User u = User.builder()
                .id(id.toHexString())
                .wordGroups(new HashMap<>())
                .build();

        WordGroup wordGroup = WordGroup.builder()
                .id(id.toHexString())
                .fishCards(new HashMap<>())
                .build();

        u.addWordGroup(wordGroup);
        return u;
    }


}