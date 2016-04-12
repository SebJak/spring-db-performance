package com.langpath.data.model.entity.word;

import com.langpath.data.model.entity.base.BaseEntity;
import com.langpath.data.model.entity.user.User;
import common.model.enums.Language;
import common.model.enums.ValidationState;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Sebastian on 2016-03-16.
 *
 * The entity represents WordGroup detials.
 */

@Setter
@Getter
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        WordGroup wordGroup = (WordGroup) o;

        return name.equals(wordGroup.name);
//         owner.equals(wordGroup.owner);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
//        result = 31 * result + owner.hashCode();
        return result;
    }
}
