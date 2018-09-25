package com.langpath.data.model.entity.word;

import com.langpath.data.model.entity.user.User;
import com.model_old.enums.Language;
import com.model_old.enums.ValidationState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

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
public class WordGroup {

    @Getter(AccessLevel.NONE)
    final static long serialVersionUID = 1l;

    @Id
    @Column(name = "ID", columnDefinition = "serial")
    @SequenceGenerator(name="word_group_id_seq",
            sequenceName="word_group_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="word_group_id_seq")
    private Long id;


    @Column(nullable = false, length = 64)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ownerId")
    private User owner;

    @ManyToMany(mappedBy = "wordGroups", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<User> users;

    @Enumerated(EnumType.STRING)
    @Column(length = 64, nullable = false)
    private Language sourceLang;

    @Column(length = 128)
    private String description;

    private Boolean open;

    @Enumerated(EnumType.STRING)
    @Column(length = 64)
    private ValidationState validation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        WordGroup wordGroup = (WordGroup) o;

        return name.equals(wordGroup.name);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
