package com.langpath.neo4j.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Sebastian on 2016-04-12.
 */
@NodeEntity
@Getter
@Setter
public class WordGroup implements Serializable {

    @Getter(AccessLevel.NONE)
    final static long serialVersionUID = 1l;

    @GraphId
    private Long id;

    @Relationship(direction = Relationship.OUTGOING)
    private Comparable<Word> words;

    @DateString("yy-MM-dd")
    private Date lastTraining;

    private String name;

}
