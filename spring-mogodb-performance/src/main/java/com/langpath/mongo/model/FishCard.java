package com.langpath.mongo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sebastian on 2016-05-03.
 */
@Data
public class FishCard implements Serializable {

    final static long serialVersionUID = 1l;

    private Word word; //FIXME remove it and store only list fo words.

    private List<Word> meanings;

}
