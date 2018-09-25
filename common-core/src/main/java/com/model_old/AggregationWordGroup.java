package com.model_old;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * Created by Sebastian on 2016-03-22.
 */
@Data
@AllArgsConstructor
public class AggregationWordGroup implements Serializable{

    @Getter(AccessLevel.NONE)
    final static long serialVersionUID = 1l;

    private String name;

    private long count;


}
