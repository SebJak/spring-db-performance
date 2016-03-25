package com.langpath.data.model.entity.user;

import com.langpath.data.model.entity.base.BaseEntity;
import com.langpath.data.model.entity.word.WordGroup;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Sebastian on 2016-03-14.
 *
 * The entity represents User details.
 */

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="USERS")
public class User extends BaseEntity {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    static long serialVersionUID = 1l;

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(
            name="USR_WORD_GR",
            joinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="WORD_GROUP_ID", referencedColumnName="ID"))
    private Set<WordGroup> wordGroups;

    //TODO
    /*
        - types od user STUDENT, TUTOR
        - groups of users,
        - some address data ect.
     */


}
