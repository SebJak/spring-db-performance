package com.langpath.mongo.command;

import com.langpath.mongo.model.User;
import com.langpath.mongo.model.Word;
import com.langpath.mongo.model.WordGroup;
import com.service.api.CrudApi;

public class WordGroupInfo {

    private FindWorstAnsweredGroup findWorstAnsweredWord = new FindWorstAnsweredGroup();

    private CrudApi<User, String> userCrud;

    public Word findWorstAnsweredWords(String userId) {
//        return findWorstAnsweredWord
//                .findWorstAnsweredGroup(
//                        userCrud.findById(userId)
//                                .orElseThrow(()-> {throw new IllegalStateException();}))
//                .orElseThrow(()-> {throw new IllegalStateException();});
        return Word.builder().build();
    }

    WordGroup findWorstAnsweredWordGroup(String userId) throws Throwable {
        return findWorstAnsweredWord
                .findWorstAnsweredGroup(findUser(userId))
                .orElseThrow(()-> {throw new IllegalStateException();});
    }

    private User findUser(String userId) throws Throwable{
        return userCrud.findById(userId)
                .orElseThrow(()-> {throw new IllegalStateException();});
    }
}
