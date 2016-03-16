package com.langpath.sql.model.entity.base;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sebastian on 2016-03-16.
 *
 * Base entity. Keeps only common values.
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
}
