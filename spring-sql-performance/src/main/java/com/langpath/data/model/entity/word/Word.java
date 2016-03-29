package com.langpath.data.model.entity.word;

import com.langpath.data.model.entity.base.BaseEntity;
import com.langpath.data.model.enums.Language;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

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
    final static long serialVersionUID = 1l;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sourceId")
    private Word source;

    @Enumerated(EnumType.STRING)
    private Language lang;

    private String value;

    @ManyToOne(cascade = CascadeType.MERGE )
    @JoinColumn(name = "wordGroupId")
    private WordGroup wordGroup;

    @Column()
    private long wrongAnswers;

    private long goodAnswers;

    private Date lastTraining;
}
