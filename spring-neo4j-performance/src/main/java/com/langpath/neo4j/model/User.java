package com.langpath.neo4j.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Sebastian on 2016-04-10.
 */
@Getter
@Setter
@NodeEntity
public class User implements Serializable {

    @GraphId
    private Long id;

    @Getter(AccessLevel.NONE)
    final static long serialVersionUID = 1l;

    private String firstName;

    private String lastName;

    private String login;

    private String password;

    private String email;

}
