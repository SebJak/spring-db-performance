package com.langpath.data.model.entity.word;

import com.langpath.data.model.entity.base.BaseEntity;
import com.langpath.data.model.entity.user.User;
import com.langpath.data.model.enums.Language;
import com.langpath.data.model.enums.ValidationState;
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
    final static long serialVersionUID = 1l;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ownerId")
    private User owner;

    @ManyToMany(mappedBy = "wordGroups", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<User> users;

    @Enumerated(EnumType.STRING)
    private Language sourceLang;

    private String description;

    private Boolean open;

    @Enumerated(EnumType.STRING)
    private ValidationState validation;

}
