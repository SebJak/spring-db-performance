package com.langpath.mongo.model;

import common.model.enums.Language;
import common.model.enums.ValidationState;
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

    private String id;

    private String name;

    private Collection<FishCard> fishCards;

    private Date lastActivity;

    private Date createdDate;

    private String description;

    private Language sourceLang;

    private ValidationState validation;


}
