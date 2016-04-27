package com.langpath.mongo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Sebastian on 2016-04-27.
 */
@Data
@Document(collection = "WordGroups")
public class WordGroup implements Serializable {

    final static long serialVersionUID = 1l;

    private String name;

    private Collection<Word> words;

    private Date lastActivity;

    private Date createdDate;


}
