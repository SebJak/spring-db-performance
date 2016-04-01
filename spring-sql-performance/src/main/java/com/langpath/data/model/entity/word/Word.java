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
@Getter
@Setter
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

    @Override
    public String toString() {
        return "Word{" +
                "value='" + value + '\'' +
                ", source=" + source +
                ", lang=" + lang +
                ", wordGroup=" + wordGroup +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Word word = (Word) o;

        if (source != null ? !source.equals(word.source) : word.source != null) return false;
        if (lang != word.lang) return false;
        return value.equals(word.value);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + lang.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
