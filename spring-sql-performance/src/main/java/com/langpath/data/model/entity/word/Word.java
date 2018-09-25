package com.langpath.data.model.entity.word;

import com.model_old.enums.Language;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

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
public class Word {

    @Getter(AccessLevel.NONE)
    final static long serialVersionUID = 1l;

    @Id
    @Column(name = "ID", columnDefinition = "serial")
    @SequenceGenerator(name="word_id_seq",
            sequenceName="word_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="word_id_seq")
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sourceId")
    private Word source;

    @Enumerated(EnumType.STRING)
    @Column(length = 64)
    private Language lang;

    @Column(length = 64)
    private String value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wordGroupId")
    private WordGroup wordGroup;

    @Column(columnDefinition = "integer default 0")
    private int wrongAnswers;

    @Column(columnDefinition = "integer default 0")
    private int goodAnswers;

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
