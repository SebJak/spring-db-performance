package com.langpath.mongo.model;

import com.model_old.enums.Language;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Sebastian on 2016-04-27.
 */
@Data
@Builder
public class Word {

    private String value;

    private String example;

    private int answers;

    private Language lang;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word word = (Word) o;

        return value.equals(word.value) && (example != null ? example.equals(word.example) : word.example == null) && lang == word.lang;

    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + (example != null ? example.hashCode() : 0);
        result = 31 * result + lang.hashCode();
        return result;
    }
}
