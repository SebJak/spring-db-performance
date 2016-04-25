package com.langpath.neo4j.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Sebastian on 2016-04-10.
 */
@Getter
@Setter
@NodeEntity(label = "Person")
public class User implements Serializable {

    @Getter(AccessLevel.NONE)
    final static long serialVersionUID = 1l;

    @GraphId
    private Long id;

    private String firstName;

    private String lastName;

    private String login; //TODO add unique

    private String password;

    private String email; //TODO add validator

    @Relationship(direction = Relationship.OUTGOING)
    private Collection<WordGroup> wordGroups;

}
