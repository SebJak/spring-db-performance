package com.langpath.sql.model.entity.word;

import com.langpath.sql.model.entity.base.BaseEntity;
import com.langpath.sql.model.enums.Language;
import lombok.*;

import javax.persistence.*;

/**
 * Created by Sebastian on 2016-03-16.
 *
 * The entity represents Word details.
 */
@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="WORD")
public class Word extends BaseEntity {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    static long serialVersionUID = 1l;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sourceId")
    private Word source;

    @Enumerated(EnumType.STRING)
    private Language lang;

    private String value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wordGroupId")
    private WordGroup wordGroup;
}
