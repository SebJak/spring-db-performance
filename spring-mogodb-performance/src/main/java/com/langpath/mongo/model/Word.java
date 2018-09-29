package com.langpath.mongo.model;

import com.model_old.enums.Language;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Sebastian on 2016-04-27.
 */
@Data
public class Word implements Serializable {

    final static long serialVersionUID = 1l;

    private String value;

    private String example;

    private int answers;

    private Language lang;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word word = (Word) o;

        if (answers != word.answers) return false;
        if (!value.equals(word.value)) return false;
        if (example != null ? !example.equals(word.example) : word.example != null) return false;
        return lang == word.lang;

    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + (example != null ? example.hashCode() : 0);
        result = 31 * result + answers;
        result = 31 * result + lang.hashCode();
        return result;
    }
}
