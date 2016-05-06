package com.langpath.mongo.model;

import common.model.enums.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Sebastian on 2016-04-27.
 */
@Data
@Document(collection = "users")
public class User implements Serializable{

    @Indexed
    @Id
    private String id;

    @Indexed
    private String nick;

    private String firstName;

    private String lastName;

    private String password;

    @Indexed
    private String email;

    @Indexed
    private Role role;

    private Set<String> wordGroups;
}
