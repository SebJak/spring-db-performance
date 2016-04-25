package com.langpath.neo4j.model;

import common.model.enums.Language;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Sebastian on 2016-04-12.
 */
@NodeEntity
@Getter
@Setter
public class Word implements Serializable {

    @Getter(AccessLevel.NONE)
    final static long serialVersionUID = 1l;

    @GraphId
    private Long id;

    @Relationship(direction = Relationship.INCOMING)
    private WordGroup wordGroup;

    //@EnumString(Language.class)
    private Language language;

    private String value;

    private long goodAnswers;

    private long badAnswers;

    @Relationship(direction = Relationship.UNDIRECTED)
    private Collection<Word> meanings;

}