package com.langpath.sql.model.entity.word;

import com.langpath.sql.model.entity.base.BaseEntity;
import com.langpath.sql.model.entity.user.User;
import com.langpath.sql.model.enums.Language;
import com.langpath.sql.model.enums.ValidationState;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Sebastian on 2016-03-16.
 *
 * The entity represents WordGroup detials.
 */

@Data
@EqualsAndHashCode(callSuper = true, exclude={"users"})
@Entity
@Table(name="WORD_GROUP")
public class WordGroup extends BaseEntity {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    static long serialVersionUID = 1l;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ownerId")
    private User owner;

    @ManyToMany(mappedBy = "wordGroups", fetch = FetchType.LAZY)
    private Set<User> users;

    @Enumerated(EnumType.STRING)
    private Language sourceLang;

    private String description;

    private Boolean open;

    @Enumerated(EnumType.STRING)
    private ValidationState validation;

}
