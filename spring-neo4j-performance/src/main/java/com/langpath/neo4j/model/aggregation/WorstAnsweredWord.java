package com.langpath.neo4j.model.aggregation;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.annotation.QueryResult;

/**
 * Created by root on 14.10.16.
 */
@Getter
@Setter
@QueryResult
public class WorstAnsweredWord {
        long userId;
        long wordGroupId;
        String wordValue;
        long badAnswers;
}

