package com.langpath.mongo.model;

import com.model_old.enums.Language;
import com.model_old.enums.ValidationState;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sebastian on 2016-04-27.
 */
@Data
@Builder
public class WordGroup implements Serializable {

    private String id;

    private String name;

    private Map<Word, Word> fishCards;

    private LocalDateTime lastActivity;

    private LocalDateTime createdDate = LocalDateTime.now();

    private String description;

    private Language sourceLang;

    private Long positiveAnswers = 0L;

    public static class WordGroupBuilder{
        private LocalDateTime createdDate = LocalDateTime.now();
        private Map<Word, Word> fishCards = new HashMap<>();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WordGroup)) return false;

        WordGroup wordGroup = (WordGroup) o;
        return id.equals(wordGroup.id);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }




}
