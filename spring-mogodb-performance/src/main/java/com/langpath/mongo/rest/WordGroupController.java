package com.langpath.mongo.rest;

import com.langpath.mongo.model.User;
import com.langpath.mongo.model.WordGroup;
import com.service.api.CrudApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController()
public class WordGroupController {


    @Autowired @Qualifier("userCrudService")
    CrudApi<User, String> userCrudService;

    @PostMapping(path = "{userId}/wordGroup/")
    public void createWordGroup(@PathVariable String userId, @RequestBody WordGroup wordGroup) {
        userCrudService.findById(userId)
                .map(user -> user.addWordGroup(wordGroup))
                .map(user -> userCrudService.save(user))
        .orElseThrow(()-> {throw new IllegalStateException("Can not save word group for current user");});
    }

    @GetMapping(path = "{userId}/wordGroup/{wordGroupId}") //FIXME Check how to return 404 in case of not found.
    public WordGroup getWordGroup(@PathVariable String userId, @PathVariable String wordGroupId) {
        return userCrudService.findById(userId)
                .map(user -> user.getWordGroups().get(wordGroupId))
                .orElseThrow(()-> {throw new IllegalStateException("Can not find word group for current user");});
    }

    @PutMapping(path = "{userId}/wordGroup/")
    public void updateWordGroup(@PathVariable String userId, @RequestBody WordGroup wordGroup) {
        userCrudService.findById(userId)
                .map(user -> user.updateWordGroup(wordGroup))
                .map(user -> userCrudService.save(user))
                .orElseThrow(()-> {throw new IllegalStateException("Can not save word group for current user");});
    }


}
