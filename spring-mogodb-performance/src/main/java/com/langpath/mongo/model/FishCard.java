package com.langpath.mongo.model;

import common.model.enums.Language;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Sebastian on 2016-05-03.
 */
@Data
public class FishCard implements Serializable {

    final static long serialVersionUID = 1l;

    private Word word;

    private Map<Language, Word> meanings;

}
