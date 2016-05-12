package com.langpath.mongo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Sebastian on 2016-04-27.
 */
@Data
public class Word implements Serializable {

    final static long serialVersionUID = 1l;

    private String id;

    private String value;

    private String example;

}
