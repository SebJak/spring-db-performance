package com.langpath.commands;

import com.langpath.data.repositories.UserRepository;
import com.model_old.WorstAnsweredWord;
import com.model_old.enums.Count;
import org.springframework.stereotype.Service;

/**
 * Created by root on 13.10.16.
 */
@Service
public class GetWorstAnsweredWord extends AbstractCommand {

    private UserRepository userRepository;

    public GetWorstAnsweredWord(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    Find the word from each users words which has the biggest number of wrong answers
    Select word from word  2746,2651469,temporary worker,70782,9
    where
     */

    WorstAnsweredWord getWorstWordForUser(long userId) {
        String concatenateResult =  userRepository.getWorstAnswered(userId); //FIXME improve it to @NamedStoredProcedure
        //System.out.println(concatenateResult);
        String[] result =  concatenateResult.split(",");
        if(result!=null && result.length == 5) {
            WorstAnsweredWord info = new WorstAnsweredWord(Integer.parseInt(result[1]), Integer.parseInt(result[2]),result[3], Integer.parseInt(result[0]), Integer.parseInt(result[4]));
            return info;
        }
        return null;
    }
}
