package com.langpath.mongo.model;

import com.model_old.enums.Language;
import com.model_old.enums.ValidationState;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Sebastian on 2016-04-27.
 */
@Data
public class WordGroup implements Serializable {

    private String id;

    private String name;

    private Collection<FishCard> fishCards;

    private Date lastActivity;

    private Date createdDate;

    private String description;

    private Language sourceLang;

    private ValidationState validation;

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
