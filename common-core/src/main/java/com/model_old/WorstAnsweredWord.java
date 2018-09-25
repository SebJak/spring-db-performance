package com.model_old;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by root on 13.10.16.
 */

@Data
@AllArgsConstructor
public class WorstAnsweredWord implements Serializable{

    public int wordId;

    public int wordGroupId;

    public String valueWord;

    public int userId;

    public int wrongAnswers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorstAnsweredWord)) return false;

        WorstAnsweredWord that = (WorstAnsweredWord) o;

        if (wordGroupId != that.wordGroupId) return false;
        if (userId != that.userId) return false;
        if (wordId != that.wordId) return false;
        if (wrongAnswers != that.wrongAnswers) return false;
        if (valueWord != null ? !valueWord.equals(that.valueWord) : that.valueWord != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = wordGroupId ^ (wordGroupId >>> 32);
        result = 31 * result + (userId ^ (userId >>> 32));
        result = 31 * result + (wordId ^ (wordId >>> 32));
        result = 31 * result + (valueWord != null ? valueWord.hashCode() : 0);
        result = 31 * result + wrongAnswers;
        return result;
    }

    @Override
    public String toString() {
        return "WorstAnsweredWord{" +
                "wordGroupId=" + wordGroupId +
                ", userId=" + userId +
                ", wordId=" + wordId +
                ", valueWord='" + valueWord + '\'' +
                ", wrongAnswers=" + wrongAnswers +
                '}';
    }
}
