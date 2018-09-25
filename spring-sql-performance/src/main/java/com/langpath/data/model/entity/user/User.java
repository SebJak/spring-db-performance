package com.langpath.data.model.entity.user;

import com.langpath.data.model.entity.word.WordGroup;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Sebastian on 2016-03-14.
 *
 * The entity represents User details.
 */

@Setter
@Getter
@Entity
/*@NamedStoredProcedureQuery(
        name="getWorstAnswered",
        procedureName="getWorstAnsweredWord",
        parameters={
            @StoredProcedureParameter(name="userId", type = Integer.class)
        },
        resultClasses = {WorstAnsweredWord.class}

)*/
@Table(name="USERS")
public class User {

    @Getter(AccessLevel.NONE)
    final static long serialVersionUID = 1l;

    @Id
    @Column(name = "ID", columnDefinition = "serial")
    @SequenceGenerator(name="users_id_seq",
            sequenceName="users_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="users_id_seq")
    private Long id;

    @Column(length = 64)
    private String firstName;

    @Column(length = 64)
    private String lastName;

    @Column(unique = true, nullable = false, length = 64)
    private String login;

    @Column(nullable = false, length = 64)
    private String password;

    @Column(length = 64, nullable = false, unique = true)
    private String email; //todo: Add check pattern

    @ManyToMany
    @JoinTable(
            name="USR_WORD_GR",
            joinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID" ),
            inverseJoinColumns=@JoinColumn(name="WORD_GROUP_ID", referencedColumnName="ID"))
    private Set<WordGroup> wordGroups;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        return login.equals(user.login);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + login.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
