package com.langpath.mongo.model;

import com.model_old.enums.Language;
import com.model_old.enums.ValidationState;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * Created by Sebastian on 2016-04-27.
 */
@Data
public class WordGroup implements Serializable {

    private String id;

    private String name;

    private Map<Word, Word> fishCards;

    private LocalDateTime lastActivity;

    private LocalDateTime createdDate = LocalDateTime.now();

    private String description;

    private Language sourceLang;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WordGroup)) return false;

        WordGroup wordGroup = (WordGroup) o;
        return name.equals(wordGroup.name);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }




}
