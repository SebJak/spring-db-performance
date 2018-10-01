package com.langpath.mongo.command;

import com.langpath.mongo.model.User;
import com.langpath.mongo.model.WordGroup;
import com.service.api.CrudApi;

public class WordGroupInfo {

    private FindWorstAnsweredGroup findWorstAnsweredWord = new FindWorstAnsweredGroup();

    private CrudApi<User, String> userCrud;

    WordGroupInfo(CrudApi<User, String> userCrud) {
        this.userCrud = userCrud;
    }

    WordGroup findWorstAnsweredWordGroup(String userId) throws Throwable {
      return findWorstAnsweredWord
                .findWorstAnsweredGroup(findUser(userId)).orElse(null);
    }

    private User findUser(String userId) throws Throwable{
        return userCrud.findById(userId)
                .orElseThrow(()-> {throw new IllegalStateException();});
    }
}
