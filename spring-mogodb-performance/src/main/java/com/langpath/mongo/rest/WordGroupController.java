package com.langpath.mongo.rest;

import com.langpath.mongo.model.User;
import com.langpath.mongo.model.WordGroup;
import com.service.api.CrudApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController()
public class WordGroupController {


    @Autowired @Qualifier("userCrudService")
    CrudApi<User, String> userCrudService;

    @PostMapping(path = "{userId}/wordGroup/")
    public void createWordGroup(@PathVariable String userId, @RequestBody WordGroup wordGroup) {
        userCrudService.findById(userId)
                .map(user -> user.addWordGroup(wordGroup))
                .ifPresent(user -> userCrudService.save(user));
    }

    @GetMapping(path = "{userId}/wordGroup/{wordGroupId}") //FIXME Check how to return 404 in case of not found.
    public ResponseEntity<WordGroup> getWordGroup(@PathVariable String userId, @PathVariable String wordGroupId) {
        Optional<WordGroup> result = userCrudService.findById(userId)
                .map(user -> user.getWordGroups().get(wordGroupId));
        return result.map(wordGroup -> new ResponseEntity<>(wordGroup, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PutMapping(path = "{userId}/wordGroup/")
    public void updateWordGroup(@PathVariable String userId, @RequestBody WordGroup wordGroup) {
        userCrudService.findById(userId)
                .map(user -> user.updateWordGroup(wordGroup))
                .ifPresent(user -> userCrudService.save(user));
    }

    @GetMapping("/{userId}")
    public ResponseEntity getUserWordGroupsInfo(@PathVariable String userId){
        ResponseEntity<Map> response = new ResponseEntity<Map>(HttpStatus.NOT_FOUND);


        return response;
    }


}
