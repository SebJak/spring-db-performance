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

    private LocalDateTime lastActivity;

    private String description;

    private Language sourceLang;

    @Builder.Default
    private LocalDateTime createdDate = LocalDateTime.now();

    @Builder.Default
    private Map<Word, Word> fishCards = new HashMap<>();

    @Builder.Default
    private Long positiveAnswers = 0L;

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
